package com.hai.dao;

import com.hai.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao {

//    void login();

    @Select("SELECT U.ID,U.PHONE,U.PASSWORD FROM USER U WHERE U.ID = #{id}")
    @Results(id="User",value = {
            @Result(property = "id",column = "id" ,id = true),
            @Result(property = "phone",column = "phone" ),
            @Result(property = "password",column = "password" ),
    })
    User getUser(int id);

    @Insert("INSERT INTO USER(phone,password) VALUES(#{phone},#{password})")
    void insert(User user);


    @Select("SELECT U.ID,U.PHONE,U.PASSWORD FROM USER U WHERE U.PHONE = #{phone}")
    @ResultMap("User")
    User getUserByPhone(String phone);
}
