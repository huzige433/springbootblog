package com.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.Domain.Blog;
import com.blog.Domain.User;
import com.blog.controller.utils.R;
import com.blog.services.impl.BlogServicesLmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:8081")
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogServicesLmpl blogServicesLmpl;


    @GetMapping ("/list/{userid}")
    public R list(@PathVariable("userid") Integer userid) throws Exception {
        LambdaQueryWrapper<Blog> LWQ =new LambdaQueryWrapper();
        LWQ.select(Blog::getId,Blog::getId,Blog::getTitle,Blog::getDescript).ne(Blog::getUserid,userid);

        List<Blog> blogs = blogServicesLmpl.list(userid);
        if (blogs != null) {
            return new R(true, blogs, "列表展示成功");
        } else {
            return new R(false, null, "列表展示失败");
        }
    }

    @PostMapping("/save")
    public R save(User user,@RequestBody Blog blog){
        Integer userid=user.getId();
        blog.setUserid(userid);
        Boolean flag=blogServicesLmpl.save(blog);
        return new R(flag, blog, flag?"保存成功":"保存失败");
    }

    @GetMapping("/article")
    @Cacheable(value = "article",unless = "#result == null",key = "#articleid")
    public  Blog article(@RequestParam Integer articleid){
        Blog blog=blogServicesLmpl.getById(articleid);
        return blog;
    }

    @GetMapping("/page")
    public R page(@RequestParam int currentPage,@RequestParam int pageSize,@RequestParam int userid){
        LambdaQueryWrapper<Blog> lqw=new LambdaQueryWrapper();
        lqw.eq(Blog::getUserid,userid);
        IPage page=new Page(currentPage,pageSize);
        IPage iPage=blogServicesLmpl.page(page,lqw);
        return new R(iPage.getRecords(),iPage.getTotal());

    }

}
