package com.dykj.webApi.security.utils;

import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * @author:ctj
 * @date:2023/8/29
 * @Description: 密码工具类
 */
public class PasswordEncoderUtils {

    @Resource
    private static PasswordEncoder passwordEncoder;

    /**
     * 密码加密
     * @param password 明文密码
     * @return String
     */
    public static String encodePassword(String password){
        return passwordEncoder.encode(password);
    }

    /**
     * 密码校验
     * @param decodePassword 解码密码,即用户输入的密码
     * @param encodePassword 编码密码
     * @return boolean
     */
    public static boolean matchesPassword(String decodePassword,String encodePassword){
        return passwordEncoder.matches(decodePassword,encodePassword);
    }
}
