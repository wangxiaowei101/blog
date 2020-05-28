package com.wxw.blog.web.user;

import com.wxw.blog.po.User;
import com.wxw.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.*;
import java.util.Objects;
import java.util.Properties;

/**
 * @author wxw
 * @data 2020/5/19 18 :46
 * @description
 */

@Controller
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;
    private  String lastUrl=null;

    @GetMapping("/userlogin")
    public String loginPage(HttpServletRequest request) {
      lastUrl=request.getHeader("Referer");
        Cookie[] cookies = request.getCookies();
        if(cookies!=null)
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("ck")){
                    String[] split = cookie.getValue().split("-");

                    request.setAttribute("username",split[0]);
                    request.setAttribute("password",split[1]);

                }
            }

        return "user/userlogin";

    }

    @GetMapping("/toRegister")
    public String loginPage1(HttpServletRequest request) {
        lastUrl=request.getHeader("Referer");
        return "user/toRegister";
    }






    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session, String remember,
                        RedirectAttributes attributes, HttpServletResponse response) {
        if(lastUrl.contains("/User/userlogin")){
            lastUrl="/";
        }
        User user = userService.checkUser(username, password);

        if (user != null) {
            user.setPassword(null);
            session.setAttribute("user1",user);
            if (remember != null) {
                Cookie cookie = new Cookie("ck", username + "-" + password);
                cookie.setMaxAge(60 * 60 * 365);
                response.addCookie(cookie);
            } else {
                Cookie cookie = new Cookie("ck", "");
                cookie.setMaxAge(0);
                response.addCookie(cookie);
            }

            return "redirect:"+lastUrl;
        } else {
            attributes.addFlashAttribute("message", "用户名和密码错误");
            return "redirect:/User/userlogin";
        }
        }

    @PostMapping("/register")
    public String toRegister(User user, @RequestParam("Verification") String  Verification, RedirectAttributes attributes,
                              HttpSession session){

        //后端表单校验
        if(!user.getUsername().matches("^[a-zA-Z][a-zA-Z0-9_]{4,15}$")){
            attributes.addFlashAttribute("message","用户名必须以字母开头，长度在5~16之间，允许字母数字下划线");
            return "redirect:/User/toRegister";
        }
        if(!user.getNickname().matches("(^[a-zA-Z]{2,5}$)|(^[\\u2E80-\\u9FFF]{2,5}$)")){
            attributes.addFlashAttribute("message","昵称必须是2-5位中文或以字母开头的2-5位英文和数字组合");
            return "redirect:/User/toRegister";
        }
        if(!user.getPassword().matches("^[a-zA-Z]\\w{5,17}$")){
            attributes.addFlashAttribute("message","密码必须以字母开头，长度在6~18之间，只能包含字符、数字和下划线");
            return "redirect:/User/toRegister";
        }
        if(!user.getEmail().matches("^\\w+@[0-9a-zA-Z]{2,4}\\.[a-zA-Z]{2,3}(\\.[a-zA-Z]{2,3})?$")){
            attributes.addFlashAttribute("message","邮箱格式错误");
            return "redirect:/User/toRegister";
        }

        if(lastUrl.contains("/User/userlogin")){
            lastUrl="/";
        }
        User userByName = userService.findUserByName(user.getUsername());
        User userByEmail = userService.findUserByEmail(user.getEmail());

        String code =(String)session.getAttribute("code");
      /*  System.out.println(code);
       System.out.println(Verification);*/
        if (userByName==null){
            if (userByEmail==null){
                if (Objects.equals(code,Verification)){

                    userService.saveUser(user);
                    return "redirect:"+lastUrl;
                }
                else {
                    attributes.addFlashAttribute("message", "验证码错误");
                }
            }else {
                attributes.addFlashAttribute("message", "邮箱以被注册");
            }

        }else {
            attributes.addFlashAttribute("message", "用户名以被注册");
        }


        return "redirect:/User/toRegister";
    }



    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user1");
        return "redirect:"+lastUrl;
    }


    @RequestMapping("/sms")
    @ResponseBody
    public String smsCode(@RequestParam("email") String email,HttpServletRequest request,HttpSession session) throws Exception {
        String sendEmailAccount = "1281443565@qq.com";
        String sendEmailPwd = "cvbfxrlalfkehhca";
        //public static String receiveMailAccount = "yx1";


        //发件人邮箱服务器地址
  String emailProtocolType = "smtp";
    String sendEmailSMTPHost = "smtp.qq.com";
   String smtpPort = "465";
   String sslSocketFactory = "javax.net.ssl.SSLSocketFactory";

        // 1. 创建参数配置, 用于连接邮件服务器的参数配置
        Properties props = new Properties();                    // 参数配置
        props.setProperty("mail.transport.protocol", emailProtocolType);   // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.smtp.host", sendEmailSMTPHost);   // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "true");            // 需要请求认证

        // PS: 某些邮箱服务器要求 SMTP 连接需要使用 SSL 安全认证 (为了提高安全性, 邮箱支持SSL连接, 也可以自己开启),
        //     如果无法连接邮件服务器, 仔细查看控制台打印的 log, 如果有有类似 “连接失败, 要求 SSL 安全连接” 等错误,
        //     打开下面 /* ... */ 之间的注释代码, 开启 SSL 安全连接。
        /*
        // SMTP 服务器的端口 (非 SSL 连接的端口一般默认为 25, 可以不添加, 如果开启了 SSL 连接,
        //                  需要改为对应邮箱的 SMTP 服务器的端口, 具体可查看对应邮箱服务的帮助,
        //                  QQ邮箱的SMTP(SLL)端口为465或587, 其他邮箱自行去查看)
         */

        //ssl安全认证
        props.setProperty("mail.smtp.port", smtpPort);
        //设置socketfactory
        props.setProperty("mail.smtp.socketFactory.class", sslSocketFactory);
        //只处理SSL的连接, 对于非SSL的连接不做处理
        props.setProperty("mail.smtp.socketFactory.fallback", "true   ");
        props.setProperty("mail.smtp.socketFactory.port", smtpPort);

        // 2. 根据配置创建会话对象, 用于和邮件服务器交互
        Session session1 = Session.getInstance(props);
        session1.setDebug(true);  // 设置为debug模式, 可以查看详细的发送 log

        // 3. 创建一封邮件


        MimeMessage message = JavaMailDemo.createMimeMessage(session1, sendEmailAccount, email);
        String content =(String) message.getContent();

        session.setAttribute("code",content);
        // 4. 根据 Session 获取邮件传输对象
        Transport transport = session1.getTransport();

        // 5. 使用 邮箱账号 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则报错
        //
        //    PS_01: 成败的判断关键在此一句, 如果连接服务器失败, 都会在控制台输出相应失败原因的 log,
        //           仔细查看失败原因, 有些邮箱服务器会返回错误码或查看错误类型的链接, 根据给出的错误
        //           类型到对应邮件服务器的帮助网站上查看具体失败原因。
        //
        //    PS_02: 连接失败的原因通常为以下几点, 仔细检查代码:
        //           (1) 邮箱没有开启 SMTP 服务;
        //           (2) 邮箱密码错误, 例如某些邮箱开启了独立密码;
        //           (3) 邮箱服务器要求必须要使用 SSL 安全连接;
        //           (4) 请求过于频繁或其他原因, 被邮件服务器拒绝服务;
        //           (5) 如果以上几点都确定无误, 到邮件服务器网站查找帮助。
        //
        //    PS_03: 仔细看log, 认真看log, 看懂log, 错误原因都在log已说明。
        transport.connect(sendEmailAccount, sendEmailPwd);

        // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
        transport.sendMessage(message, message.getAllRecipients());

        // 7. 关闭连接
        transport.close();
        return content;
    }
}
