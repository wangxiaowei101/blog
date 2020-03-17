package com.wxw.blog.service;


import com.wxw.blog.dao.UserRepository;
import com.wxw.blog.po.User;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User checkUser(String username, String password) {

        String md5password = DigestUtils.md5Hex(password);
        User user = userRepository.findByUsernameAndPassword(username,md5password);
        System.out.println(md5password);
        return user;
    }
}
