package com.H.Modle;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dell on 2017/3/10.
 */
//注册缓冲区，用于存放已经注册但未验证的用户信息表
@Component
public class RegisterMap {
    private Map<String,User> registermap;


    public RegisterMap() {
        registermap=new HashMap<String,User>();
    }

    public Map<String, User> getRegistermap() {
        return registermap;
    }

    public void setRegistermap(Map<String, User> registermap) {
        this.registermap = registermap;
    }


}
