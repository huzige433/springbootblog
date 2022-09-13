package com.blog.controller.utils;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

//统一表现层返回数据格式
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class R<T> implements Serializable {
//    返回状态
    private Boolean flag;
//    返回数据
    private T data;

    private String msg;

    private long total;

    private String token;

    public R(Boolean flag){
        this.flag=flag;
    }
    public R(T data){
        this.data=data;
    }
    public R(T data,long total){
        this.data=data;
        this.total=total;
    }
    public R(Boolean flag,T data){
        this.flag=flag;
        this.data=data;
    }
    public R(Boolean flag,T data,String msg){
        this.flag=flag;
        this.data=data;
        this.msg=msg;
    }
    public R(Boolean flag,T data,String token,String msg){
        this.flag=flag;
        this.data=data;
        this.msg=msg;
        this.token=token;
    }

}
