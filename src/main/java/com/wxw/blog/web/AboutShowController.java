package com.wxw.blog.web;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wxw
 * @data 2020/3/11 18 :45
 * @description
 */
@Controller
public class AboutShowController {

    @RequestMapping("about")
    public  String about(){
        return  "about";
    }
}
