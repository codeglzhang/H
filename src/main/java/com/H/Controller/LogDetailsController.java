package com.H.Controller;

import com.H.Modle.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by dell on 2017/3/9.
 */
@RestController
public class LogDetailsController {
    @Autowired
    LoggerRepository loggerRepository;
    @Autowired
    SysUserRepository sysUserRepository;
   /* @GetMapping("/login")
    public String h(){
        return "11111";
    }*/
    @PostMapping("/login/")
    public String loadUserByUsername(@RequestBody Logger loggerclient){
        Logger loggerUser=loggerRepository.findByName(loggerclient.getName());
        if(loggerUser==null){
            //throw new UsernameNotFoundException()
            return "False";
        }
        else if (loggerclient.getPassword().equals(loggerUser.getPassword())){
            return "True";
        }
        return "False";
    }

   /*@RequestMapping("/")
    public Logger fff(Long id){
        Logger logger=new Logger();
        logger.setPassword("123456798");
        logger.setName("zhang");
        return logger;
    }*/
   /* @RequestMapping("/login")
    public String loadUserByUsername(){
        Logger loggerclient=new Logger();
        loggerclient.setName("zhang");
        loggerclient.setPassword("123456");

        Logger loggerUser=userRepository.findByName(loggerclient.getName());
        if(loggerUser==null){
            //throw new UsernameNotFoundException()
            return "False";
        }
        else if (loggerclient.getPassword().equals(loggerUser.getPassword())){
            return "True";
        }
        return "False";
    }*/

}
