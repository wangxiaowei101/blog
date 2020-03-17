package com.wxw.blog.service;


import com.wxw.blog.po.Comment;

import java.util.List;


public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    Comment saveComment(Comment comment);

    void deleteComment(Long id);
}
