package com.blog.services.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.Domain.Blog;
import com.blog.dao.BlogDao;
import com.blog.services.IBlogService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogServicesLmpl extends ServiceImpl<BlogDao,Blog> implements IBlogService {

    //sql数据缓存到redis
    @Cacheable(cacheNames = "Userredis", key = "#userid")
    public List<Blog> list(Integer userid) {
        LambdaQueryWrapper<Blog> lqw=new LambdaQueryWrapper<>();
        lqw.eq(Blog::getUserid,userid);
        return super.list(lqw);
    }

    @Override
    @Cacheable(value = "pageredis",unless = "#result == null",key = "#page.current+':'+#page.size")
    public <E extends IPage<Blog>> E page(E page, Wrapper<Blog> queryWrapper) {
        return super.page(page, queryWrapper);
    }

    @Override
    @Cacheable(cacheNames = "pageredis", key = "#page.current+'-'+#page.size")
    public <E extends IPage<Blog>> E page(E page) {
        return super.page(page);
    }
}
