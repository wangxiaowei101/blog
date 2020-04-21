package com.wxw.blog;

import com.wxw.blog.dao.BlogRepository;
import com.wxw.blog.dao.CommentRepository;
import com.wxw.blog.dao.TagRepository;
import com.wxw.blog.dao.UserRepository;
import com.wxw.blog.po.Comment;
import com.wxw.blog.po.Tag;
import com.wxw.blog.po.User;
import com.wxw.blog.service.BlogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class BlogApplicationTests {

    @Autowired
    private TagRepository userRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Test
    void contextLoads() {

        Tag wxw = userRepository.findByName("linux");
        System.out.println("_______________________"+wxw.toString());


    }

}
