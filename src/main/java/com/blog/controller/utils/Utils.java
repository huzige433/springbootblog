package com.blog.controller.utils;

import javax.servlet.http.Cookie;

public class Utils {
    public static String getValue(Cookie[] cookies,String key){
        String logintoken=null;
        for(Cookie acookie:cookies){
            String name = acookie.getName();
            String value = acookie.getValue();
            if(name.equals("login-token")){
                logintoken=value;
            }
        }
        return logintoken;
    }


}
