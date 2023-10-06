package com.hai.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.hai.entity.User;
import com.hai.exception.LoginErrorException;
import com.hai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/seckill")
public class UserController {

    @Autowired
    UserService userService;

        @RequestMapping("/getUser")
        @ResponseBody
        public User getUser(int id){

           return userService.getUser(id);

        }

        @RequestMapping(value = "/login",method = RequestMethod.POST)
        public String login(String phone,String password){
//            System.out.println("登录成功！");
            String result = userService.login(phone,password);
            if (result.contains("登录成功")){
                return "redirect:/commodityList";
            }else {
                //登录失败
//                return "index.jsp";
                throw new LoginErrorException("账户不存在或账号或密码错误！");
            }

        }


        @RequestMapping(value = "/register",method = RequestMethod.GET)
        public String register(String phone,String password){
            System.out.println("注册成功!");
            User user = new User(null,phone,password);
            userService.register(user);
            return "register";
        }
}
