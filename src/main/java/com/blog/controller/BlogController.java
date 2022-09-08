package com.blog.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.Domain.Blog;
import com.blog.Domain.User;
import com.blog.controller.utils.R;
import com.blog.services.impl.BlogServicesLmpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogServicesLmpl blogServicesLmpl;


    @GetMapping ("/list")
    public R list(User user) throws Exception {
        Integer userid=user.getId();
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
    public  R article(@RequestParam String articleid){
        Blog blog=blogServicesLmpl.getById(articleid);
        return new R(blog);
    }

    @GetMapping("/page")
    public R page(@RequestParam int pagecount,@RequestParam int pageSize){
        IPage<Blog> page=new Page(pagecount,pageSize);
        IPage iPage=blogServicesLmpl.page(page);
        return new R(iPage.getRecords());

    }

}
