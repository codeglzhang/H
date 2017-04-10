package com.H.Controller;
import com.H.Modle.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by dell on 2017/3/9.
*/
//对用户信息表进行数据库操作的接口
public interface SysUserRepository extends JpaRepository<User,Long> {
    User findByAddress(String address);
    User findByMail(String mail);
    User findByName(String name);
    User findByPassword(String password);
    @Query("select u from User u where u.name= :name and u.password= :password")
    User findByNameAndPassword(@Param("name") String name, @Param("password") String password);
}
