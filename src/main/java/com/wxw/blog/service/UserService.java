package com.wxw.blog.service;

import com.wxw.blog.po.User;


public interface UserService {

   // User checkUser(String username, String password);

    User findUserByName(String username);
}
