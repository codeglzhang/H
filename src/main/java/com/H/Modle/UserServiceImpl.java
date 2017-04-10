package com.H.Modle;

import com.H.Controller.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by dell on 2017/4/9.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private SysUserRepository userRepository;

    @Override
    public User findByNameAndPassword(User user) {
        // TODO Auto-generated method stub
        return userRepository.findByNameAndPassword(user.getName(), user.getPassword());
    }

    @Override
    public User getByUsername(String username) {
        // TODO Auto-generated method stub
        return userRepository.findByName(username);
    }
}