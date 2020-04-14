package com.wxw.blog.service;


import com.sun.crypto.provider.BlowfishKeyGenerator;
import com.wxw.blog.po.Blog;
import com.wxw.blog.vo.BlogQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface BlogService {

    Blog getBlog(Long id);
    //编辑器转换
    Blog getAndConvert(Long id);

    Page<Blog> listBlog(Pageable pageable, BlogQuery blog);

    Page<Blog> listBlog(Pageable pageable);

    Page<Blog> listBlog(Long tagId,Pageable pageable);
    //全局搜索
    Page<Blog> listBlog(String query,Pageable pageable);

    //前端显示
    List<Blog> listRecommendBlogTop(Integer size);

    Map<String,List<Blog>> archiveBlog();

    Long countBlog();

    Blog saveBlog(Blog blog);

    Blog updateBlog(Long id, Blog blog);

    List<Blog>  getBlogType(Long id);

    void deleteBlog(Long id);
}
