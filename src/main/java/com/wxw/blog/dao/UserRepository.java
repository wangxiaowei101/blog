package com.wxw.blog.dao;


import com.wxw.blog.po.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<User,Long> {

    //User findByUsernameAndPassword(String username, String password);
    @Query("select b from User b where b.username=?1")
    User  findUserByName(String  username);

}
