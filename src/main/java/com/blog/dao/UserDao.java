package com.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.Domain.User;
import org.apache.ibatis.annotations.Mapper;

//数据层本应该有sql语句,通过注解省略了
@Mapper
public interface UserDao extends BaseMapper<User> {

}
