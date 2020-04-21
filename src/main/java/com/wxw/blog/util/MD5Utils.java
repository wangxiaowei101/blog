package com.wxw.blog.util;

import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * @author wxw
 * @data 2020/4/19 21 :20
 * @description
 */
public class MD5Utils {

    public  static  String md5Hash(String str ,String salt,int count){
        return new Md5Hash(str,salt,count).toString();
    }

}
