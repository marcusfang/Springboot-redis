package com.didispace.domain;

import java.io.Serializable;


public class User implements Serializable {

    private static final long serialVersionUID = -1L;
    private String nickName;
    private String username;
    private Integer age;

    public User(String nickName,String username, Integer age) {
        this.nickName = nickName;
        this.username = username;
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
