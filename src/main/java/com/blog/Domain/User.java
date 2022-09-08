package com.blog.Domain;

import lombok.Data;

import java.io.Serializable;

//实体类
@Data
public class User implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private Integer type;
}
