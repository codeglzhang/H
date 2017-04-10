package com.H.Modle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by dell on 2017/4/9.
 */
//登录验证类
@Service
public class UserDetailsServiceImple implements UserDetailsService {

    @Autowired(required = true)
    private UserService userService;//加载user的DAO操作接口

    @Override//加载用户，即验证用户登录信息
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        final User cUser = userService.getByUsername(username);
        if (cUser == null) {
            throw new UsernameNotFoundException(username + " cannot be found");
        }
        final Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("USER"));//此处设置用户角色为USER,只是为了简单对应起来
        return new org.springframework.security.core.userdetails.User(cUser.getName(), cUser.getPassword(), authorities);
    }

}
