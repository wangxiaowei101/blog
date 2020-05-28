package com.wxw.blog.web.admin;


import com.wxw.blog.po.User;
import com.wxw.blog.service.UserService;
import com.wxw.blog.util.MD5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class LoginController {


    @Autowired
    private UserService userService;

    @GetMapping
    public String loginPage(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if(cookies!=null)
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("ck")){
                    String[] split = cookie.getValue().split("-");

                    request.setAttribute("username",split[0]);
                    request.setAttribute("password",split[1]);

                }
            }

        return "admin/login";
    }


    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session, String remember,
                        RedirectAttributes attributes, HttpServletResponse response) {

        System.out.println("是否记住密码："+remember);
        Integer typeByName = userService.findTypeByName(username);
           if(typeByName!=null){


        if (typeByName==1) {


            Subject subject = SecurityUtils.getSubject();
            String md5paw = MD5Utils.md5Hash(password, username, 3);
            UsernamePasswordToken token = new UsernamePasswordToken(username, md5paw);
            try {
                subject.login(token);
                User user = userService.findUserByName(username);
                session.setAttribute("user", user);

                if (remember != null) {
                    Cookie cookie = new Cookie("ck", username + "-" + password);
                    cookie.setMaxAge(60 * 60 * 365);
                    response.addCookie(cookie);
                } else {
                    Cookie cookie = new Cookie("ck", "");
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                }

                return "admin/index";
            } catch (AuthenticationException e) {
                e.printStackTrace();
                attributes.addFlashAttribute("message", "用户名和密码错误");
                return "redirect:/admin";
            }
        }
        else {
            attributes.addFlashAttribute("message", "用户名和密码错误");
            return "redirect:/admin";
        }
           }else {
               attributes.addFlashAttribute("message", "用户名和密码错误");
               return "redirect:/admin";
           }


        /*User user = userService.checkUser(username, password);*/

     /*   if (user != null) {
            user.setPassword(null);
            session.setAttribute("user",user);


            return "admin/index";
        } else {
            attributes.addFlashAttribute("message", "用户名和密码错误");
            return "redirect:/admin";
        }*/

    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
