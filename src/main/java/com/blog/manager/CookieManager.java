package com.blog.manager;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieManager {
    private static Logger logger = LoggerFactory.getLogger(CookieManager.class);

    public static String getCookieValueByKey(HttpServletRequest request, String key) {
        String value = "";
        Cookie myCookie[] = request.getCookies();
        if (myCookie != null && myCookie.length > 0) {
            for (int n = 0; n < myCookie.length; n++) {// 设立一个循环，来访问Cookie对象数组的每一个元素
                Cookie newCookie = myCookie[n];
                logger.info("======{},{},{},{}", newCookie.getDomain(), newCookie.getName(), newCookie.getPath(),
                        newCookie.getComment());
                if (newCookie != null && (key).equals(newCookie.getName())) { // 判断元素的值是否为key中的值
                    if (StringUtils.isNotBlank(newCookie.getValue())) {
                        value = newCookie.getValue();
                    }
                }
            }
        }
        logger.info("getCookieValueByKey key:" + key + ",value:" + value);

        return value;
    }

    public static void setCookieValueByKey(HttpServletResponse response, String key, String value, int maxAge) {
        logger.info("setCookieValueByKey key:" + key + ",value:" + value);
        Cookie cookie = new Cookie(key, value);
        //cookie.setDomain("wwz114.cn");
        cookie.setPath("/");
        if (maxAge > 0) {
            cookie.setMaxAge(maxAge);
        }

        response.addCookie(cookie);
    }
}
