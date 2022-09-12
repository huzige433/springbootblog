package com.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.blog.Domain.User;
import com.blog.controller.utils.JwtUtil;
import com.blog.controller.utils.R;
import com.blog.services.impl.UserServicesLmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

//控制层,也可以当作路由层
@RestController
@CrossOrigin(origins = "http://127.0.0.1:8081")
@RequestMapping("/v1")
public class UserController {

    @Autowired
    private UserServicesLmpl userServicesLmpl;

    @GetMapping("/index")
    public String index(HttpServletRequest request){
        return "hello";
    }

    @PostMapping("/login")
    public R signin(@RequestBody User user) throws Exception {
        QueryWrapper<User> userQueryWrapper = Wrappers.query();
        userQueryWrapper.eq("username", user.getUsername());
        userQueryWrapper.eq("password", user.getPassword());
        User user1 = userServicesLmpl.getOne(userQueryWrapper);
        String token="";
        if (user1 != null) {
            Map<String, Object> info = new HashMap<>();
            Map<String,String> usermap=this.objectToMap01(user1);
            info.put("userinfo",usermap);
            token = JwtUtil.sign(user1.getId().toString(), info);
            System.out.println(token);
        }
        Boolean flag = user1 != null;
        return new R(flag, user1,token, flag ? "登录成功" : "登录失败");
    }

    @PostMapping("/register")
    public R register(@RequestBody User user) {
        QueryWrapper<User> userQueryWrapper = Wrappers.query();
        userQueryWrapper.eq("username", user.getUsername());
        if (userServicesLmpl.getOne(userQueryWrapper) == null) {
            Boolean flag = userServicesLmpl.save(user);
            return new R(flag, user, flag?"注册成功":"注册失败");
        } else {
            return new R(false, null, "账号已存在");
        }
    }

    @GetMapping ("/getusers")
    public R getusers() {
        LambdaQueryWrapper<User> LWQ =new LambdaQueryWrapper();
        LWQ.select(User::getId,User::getUsername).ne(User::getId,0);
      return   new R(true,userServicesLmpl.list(LWQ),"获取成功");
    }

    @PostMapping("/delete")
    public R Delete(@RequestBody User user) {
        QueryWrapper<User> userQueryWrapper = Wrappers.query();
        userQueryWrapper.eq("username", user.getUsername());
        System.out.println(userServicesLmpl.getOne(userQueryWrapper));
        if (userServicesLmpl.getOne(userQueryWrapper) != null) {
            Boolean flag = userServicesLmpl.remove(userQueryWrapper);
            return new R(flag, user.getUsername(), flag?"删除成功":"删除失败");
        } else {
            return new R(false, null, "账号不存在");
        }
    }

    /**
     对象转化为Map
     */
    public Map<String, String> objectToMap01(Object obj) throws Exception {
        if (obj == null) {
            return null;
        }
        Map<String, String> map = new HashMap<>();

        Field[] declaredFields = obj.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            map.put(field.getName(), field.get(obj).toString());

        }

        return map;
    }


}
