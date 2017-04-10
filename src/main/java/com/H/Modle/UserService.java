package com.H.Modle;

/**
 * Created by dell on 2017/4/9.
 */
public interface UserService {
    User findByNameAndPassword(User user);

    User getByUsername(String username);
}