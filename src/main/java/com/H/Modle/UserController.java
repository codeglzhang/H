package com.H.Modle;

import com.H.Controller.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dell on 2017/4/9.
 */
@RestController
public class UserController {

    @Autowired
    SysUserRepository userRepository;
    @GetMapping("/user/add")
    public User add() {
        return userRepository.findByName("zhang");
    }

    @RequestMapping("/user/update")
    public String update() {
        return "update";
    }
}