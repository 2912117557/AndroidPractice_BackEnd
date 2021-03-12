package com.example.demo.controller;

import com.example.demo.JsonResult;
import com.example.demo.model.User;
import com.example.demo.model.UserRepository;
import com.sun.istack.NotNull;

import org.hibernate.NonUniqueObjectException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class RegAndLoginController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/register")
    public JsonResult<Object> register(HttpServletRequest request, HttpServletResponse response){
        try{
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            userRepository.save(new User(username,password));
            return new JsonResult<Object>(0,"注册成功",null);
        }catch(Exception e){
            e.printStackTrace();
            return new JsonResult<Object>(-1,"注册失败",null);
        }
    }

    @RequestMapping ("/login")
    public JsonResult<Object> login(HttpServletRequest request, HttpServletResponse response){
        try{
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            User myUser = userRepository.findByUsername(username);
            if(myUser!=null){
                String myPassword = myUser.password;
                if(myPassword.equals(password)){
                    return new JsonResult<Object>(0,"登录成功",null);
                }else {
                    return new JsonResult<Object>(-1,"登录失败",null);
                }
            }else {
                return new JsonResult<Object>(-1,"登录失败",null);
            }
        }catch(Exception e){
            e.printStackTrace();
            return new JsonResult<Object>(-1,"登录失败",null);
        }
    }
}
