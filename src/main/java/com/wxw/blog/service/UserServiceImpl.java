package com.wxw.blog.service;


import com.wxw.blog.dao.UserRepository;
import com.wxw.blog.po.User;

import com.wxw.blog.util.MD5Utils;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User checkUser(String username, String password) {
        String md5paw = MD5Utils.md5Hash(password, username, 3);

        User user = userRepository.findByUsernameAndPassword(username,md5paw);
        System.out.println(md5paw);
        return user;
    }

    @Override
    public User findUserByName(String username) {


        return userRepository.findUserByName(username);
    }

    @Override
    public User saveUser(User user) {
        String password = user.getPassword();
        String username = user.getUsername();
        String md5paw = MD5Utils.md5Hash(password, username, 3);
        user.setPassword(md5paw);
        user.setAvatar("/images/avatar.jpg");
        user.setType(0);
        return userRepository.save(user);
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    @Override
    public Integer findTypeByName(String username) {


        return userRepository.findTypeByName(username);
    }
}
