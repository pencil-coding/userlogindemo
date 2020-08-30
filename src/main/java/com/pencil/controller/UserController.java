package com.pencil.controller;

import com.pencil.pojo.User;
import com.pencil.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public ModelAndView userLogin(User user){
        ModelAndView modelAndView = new ModelAndView();



        //判断用户名是否重名
        String username = user.getUsername();
        List<User> list = userService.findList();
        for (User user1 : list) {
            if (user1.getUsername().equals(username)){
                //有重复
                modelAndView.setViewName("login.html");
                modelAndView.addObject("usermsg","用户名已被使用");
                return modelAndView;
            }
        }

        //判断密码的复制程度，必须包含数字、特殊字符、字母
        String reger = "^(?![A-Za-z0-9]+$)(?![a-z0-9\\W]+$){6,}$";
        if (user.getPwd().matches(reger)){
            //非校验通过
            modelAndView.setViewName("login.html");
            modelAndView.addObject("pwdmsg","密码必须包含数字、字母、特殊符号，且长度大于6位");
            return modelAndView;
        }

        //插入数据
        userService.addUser(user);

        modelAndView.setViewName("success.html");

        return modelAndView;
    }

    @RequestMapping("/")
    public ModelAndView toLogin(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login.html");
        return modelAndView;
    }

}
