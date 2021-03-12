package com.example.demo.model;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue
    public Long id;
    @Column(nullable = false,unique = true)//unique没处理
    public String username;
    @Column(nullable = false)
    public String password;

    public User(){}

    public User(String username,String password){
        this.username=username;
        this.password=password;
    }
}
