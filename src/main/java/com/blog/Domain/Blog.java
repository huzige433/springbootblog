package com.blog.Domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

//实体类
@Data
public class Blog {
    private Integer id;
    private String title;
    private String content;
    private Integer userid;

}
