package com.blog.controller.utils;

import lombok.Data;

//统一表现层返回数据格式
@Data
public class R {
//    返回状态
    private Boolean flag;
//    返回数据
    private Object data;

    private String msg;

    public R(Boolean flag){
        this.flag=flag;
    }
    public R(Object data){
        this.data=data;
    }
    public R(Boolean flag,Object data){
        this.flag=flag;
        this.data=data;
    }
    public R(Boolean flag,Object data,String msg){
        this.flag=flag;
        this.data=data;
        this.msg=msg;
    }

}
