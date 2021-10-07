package com.itcast.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {

    private static BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();

    private static String encodePassword(String password){
       return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String s = "123456";
        String password = encodePassword(s);
        System.out.println(password);
    }
}
