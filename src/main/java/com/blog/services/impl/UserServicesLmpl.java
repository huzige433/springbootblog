package com.blog.services.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.Domain.User;
import com.blog.dao.UserDao;
import com.blog.services.IUserServices;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service
public class UserServicesLmpl extends ServiceImpl<UserDao, User> implements IUserServices {
}
