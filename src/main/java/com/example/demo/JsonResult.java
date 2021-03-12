package com.example.demo;

public class JsonResult<T> {

    public int code;
    public String msg;
    public T data;

    public JsonResult(int code,String msg,T data){
        this.code=code;
        this.msg=msg;
        this.data=data;
    }
}