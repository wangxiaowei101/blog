package com.wxw.blog.web;


import com.wxw.blog.po.Blog;
import com.wxw.blog.service.BlogService;
import com.wxw.blog.service.TagService;
import com.wxw.blog.service.TypeService;
import com.wxw.blog.vo.BlogQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @author wxw
 * @data 2020/3/5 15 :29
 * @description
 */
@Controller
public class indexController {

    @Autowired
    BlogService blogService;
    @Autowired
    TypeService typeService;

    @Autowired
    TagService tagService;

    @GetMapping("/")
    public  String index(@PageableDefault(size = 8, sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable
    , Model model)  {
        System.out.println("执行分页操作---------------------------");

        model.addAttribute("page",blogService.listBlog(pageable));
        model.addAttribute("types", typeService.listTypeTop(6));
        model.addAttribute("tags", tagService.listTagTop(10));
        model.addAttribute("recommendBlogs", blogService.listRecommendBlogTop(8));
       // int i=9/0;
//        String blog=null;
//        if(blog==null){
//
//            throw new NotFoundException("博客不存在");
//        }
        //System.out.println("------index------");
        return "index";
    }

    @RequestMapping("/search")
    public String search(@PageableDefault(size = 8 , sort = {"updateTime"}, direction = Sort.Direction.DESC) Pageable pageable,
                         @RequestParam("query") String query, Model model) {

        model.addAttribute("page", blogService.listBlog("%"+query+"%", pageable));
        model.addAttribute("query", query);
        System.out.println("_________________"+query);
        return "search";
    }




    @GetMapping("/blog/{id}")
    public  String blog(@PathVariable  Long id, Model model)  {
        model.addAttribute("blogId", id);
        model.addAttribute("blog",blogService.getAndConvert(id));


        // int i=9/0;
//        String blog=null;
//        if(blog==null){
//
//            throw new NotFoundException("博客不存在");
//        }
        //System.out.println("------index------");
        return "blog";
    }

    @GetMapping("/footer/newblog")
    public String newblogs(Model model) {
        model.addAttribute("newblogs", blogService.listRecommendBlogTop(3));
        return "_fragments :: newblogList";
    }
}
