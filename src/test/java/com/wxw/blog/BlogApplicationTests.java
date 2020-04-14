package com.wxw.blog;

import com.wxw.blog.dao.BlogRepository;
import com.wxw.blog.service.BlogService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlogApplicationTests {

    @Autowired
    private BlogService blogService;
    @Autowired
    private BlogRepository blogRepository;
    @Test
    void contextLoads() {
      System.out.println(blogRepository.getTypeId((long)3));

    }

}
