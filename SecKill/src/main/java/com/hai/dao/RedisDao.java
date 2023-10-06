package com.hai.dao;

import cn.hutool.core.util.StrUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@Component
public class RedisDao {
    @Autowired(required = false)
    private RedisTemplate<String,Object> redisTemplate;

    public Object get(String key){

        if (StrUtil.isEmpty(key)){

            return null;

        }

        return redisTemplate.opsForValue().get(key);
    }

    public boolean set(String key,Object value){
        try{
            redisTemplate.opsForValue().set(key,value);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    //超时方法
    public boolean setex(String key,Object value,long time){



        try{
            if (time > 0){

                redisTemplate.opsForValue().set(key,value,time,TimeUnit.SECONDS);

            }else {

                set(key,value);

            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

}
