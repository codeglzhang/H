package com.H.Modle;

/**
 * Created by dell on 2017/3/9.
 */

import javax.persistence.Entity;
import javax.persistence.Id;

import sun.security.util.Password;
//数据库登陆表
@Entity
public class Logger  {
    @Id
    private String name ;//账号
    private String Password;//密码

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public Logger() {

    }


}
