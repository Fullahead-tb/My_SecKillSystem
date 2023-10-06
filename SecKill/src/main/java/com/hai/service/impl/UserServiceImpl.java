package com.hai.service.impl;

import cn.hutool.crypto.digest.DigestUtil;
import com.hai.dao.UserDao;
import com.hai.entity.User;
import com.hai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl  implements UserService {
    @Autowired
    UserDao Userdao;

    public UserServiceImpl(UserDao dao) {
        this.Userdao = dao;
    }

    public UserServiceImpl() {
    }

    public void setDao(UserDao dao) {
        this.Userdao = dao;
    }

    @Override
    public User getUser(int id) {
        return Userdao.getUser(id);
    }

    public void register(User user){
        user.setPassword(DigestUtil.md5Hex(user.getPassword()));
        Userdao.insert(user);
    }


    public String login(String phone,String password) {
        User user =  Userdao.getUserByPhone(phone);
        if (user != null){
            //说明存在一个用户
            if (user.getPassword().equals(DigestUtil.md5Hex(password)) || user.getPassword().equals(password)){
                //密码正确
                return "登录成功！";
            }
        }
        return "登录失败！";
    }
}
