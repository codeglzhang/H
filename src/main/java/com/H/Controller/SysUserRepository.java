package com.H.Controller;
import com.H.Modle.Logger;
import com.H.Modle.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by dell on 2017/3/9.
*/
//对用户信息表进行数据库操作的接口
public interface SysUserRepository extends JpaRepository<User,String> {
    User findByAddress(String address);
    User findByMail(String mail);
    User findById(Long id);
}
