package com.example.demo.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: lixin
 * Date: 2021/12/7
 * Time: 21:27
 * Description: No Description
 */
public class CommunityUtil {

    // 生成随机字符串
    public static String generateUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    //MD5加密
    //hello --> abcABC123
    //hello + jdk3i --> abcABC123NAC
    public static String md5(String key){
        if (StringUtils.isBlank(key))return null;
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }

}
