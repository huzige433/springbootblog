package com.blog.Domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

//实体类
@Data
public class Blog implements Serializable {
    private Integer id;
    private String title;
    private String content;
    private Integer userid;
    private String descript;

    public Blog() {
    }
}
