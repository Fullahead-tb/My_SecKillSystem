package com.hai.service;

import com.hai.entity.User;

public interface UserService {
    User getUser(int id);
    void register(User user);

    String login(String phone,String password);
}
