package com.H.Controller;

import com.H.Modle.RegisterMap;
import com.H.Modle.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Random;

/**
 * Created by dell on 2017/3/10.
 */
@RestController
public class RegisterController {
    @Autowired
    JavaMailSender mailSender;
    @Autowired
    SysUserRepository sysUserRepository;

    @Autowired
    RegisterMap registerMap;

    private String produce_key() {
        String key = "";
        while (true) {
            Random random = new Random();
            key = "";
            for (int number = 0; number <= 4; number++) {
                int k = random.nextInt(10);
                key = key + k;
            }
            if (registerMap.getRegistermap().containsKey(key))
                continue;
            else
                break;
        }
        return key;
    }

    @PostMapping("/login/register/mail")
    public String sendmail(@RequestBody User register) {

        final MimeMessage mimeMessage = this.mailSender.createMimeMessage();
        final MimeMessageHelper message = new MimeMessageHelper(mimeMessage);

        User user= sysUserRepository.findByMail(register.getMail());//检查邮箱是否已被注册
        User user1=sysUserRepository.findByAddress(register.getAddress());//检查mac地址是否已被使用
        if(user==null&&user1==null){            //mac唯一，邮箱未被注册的话
            try {
                String key = produce_key();
                message.setFrom("3297449167@qq.com");  //发件邮箱地址（我们的邮箱）
                message.setTo(register.getMail());      //注册者的邮箱地址
                message.setSubject("H+测试邮件主题");     //邮件主题
                message.setText("测试邮件内容:这个是私人账号可以申请企业邮箱" + key);    //邮件内容加上验证码
                this.mailSender.send(mimeMessage);              //发送邮件
                registerMap.getRegistermap().put(key, register);//将注册者加入缓冲区等待验证
                return "success";                                  //返回信息给前端
            } catch (MessagingException e) {
                //e.printStackTrace();
                return "fail send";
            }
        }
        else {
            if(user==null)
                return "mail has already exit";
           else
                return "MacAddress has already exit";
        }
    }

    @GetMapping(value = "/register/mail/{key}") //用户点击的验证链接
    public String saveRegister(@PathVariable String key){
        //根据验证码获取缓冲区的注册信息并加入到数据库中
        if(registerMap.getRegistermap().containsKey(key)) {
            //将用户的详细信息加入数据库
            User user=registerMap.getRegistermap().get(key);
            sysUserRepository.save(user);

            //从缓冲区移除此用户信息
            registerMap.getRegistermap().remove(key);
            return "success";
        }else {
            return "无效验证网址";
        }
    }
}