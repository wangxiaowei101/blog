package com.wxw.blog.web;


import com.wxw.blog.po.Blog;
import com.wxw.blog.po.Comment;
import com.wxw.blog.po.User;
import com.wxw.blog.service.BlogService;
import com.wxw.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogService blogService;

    @Value("${comment.avatar}")
    private String avatar;

    @GetMapping("/comments/{blogId}")
    public String comments(@PathVariable Long blogId, Model model, HttpSession session) {

        User user = (User) session.getAttribute("user");
        if (user!=null) {
            model.addAttribute("user", user);
        }
        List<Comment> comments = commentService.listCommentByBlogId(blogId);

        model.addAttribute("comments", commentService.listCommentByBlogId(blogId));


        return "blog :: commentList";
    }


    @PostMapping("/comments")
    public String post(Comment comment, HttpSession session) {
        Long blogId = comment.getBlog().getId();
        comment.setBlog(blogService.getBlog(blogId));
        //guanliyuan
        User user = (User) session.getAttribute("user");
        //yonghu
        User user1 = (User) session.getAttribute("user1");
        comment.setNickname(user1.getNickname());
        comment.setEmail(user1.getEmail());
        if (user != null) {
            if(user.getUsername().equals(user1.getUsername())){
                comment.setAvatar(user.getAvatar());
                comment.setAdminComment(true);
            }

        } else {
            comment.setAvatar(avatar);
        }
        commentService.saveComment(comment);
        return "redirect:/comments/" + blogId;
    }


    @RequestMapping("/comments/{id}/delete")
    public String delcomments(@PathVariable Long id,@RequestParam("blogId") Long blogId, Model model) {


        commentService.deleteComment(id);
        System.out.println("----------------"+blogId);

        return "redirect:/blog/" + blogId;
    }



}
