package com.hai.dao;

import com.hai.entity.Item;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecKillItemDao {

    @Select("SELECT ITEM.ID,ITEM.NAME,ITEM.NUMBER,ITEM.PRICE,ITEM.STARTTIME,ITEM.ENDTIME,ITEM.CREATETIME FROM SECKILL_ITEM ITEM;")
    @Results(id = "Item",value = {
            @Result(property = "id",column = "id",id = true),
            @Result(property = "name",column = "name"),
            @Result(property = "number",column = "number"),
            @Result(property = "price",column = "price"),
            @Result(property = "startTime",column = "startTime"),
            @Result(property = "endTime",column = "endTime"),
            @Result(property = "createTime",column = "createTime"),
    })
    List<Item> selectItemList();


    @Select("SELECT ID,NAME,NUMBER,PRICE,STARTTIME,ENDTIME,CREATETIME FROM SECKILL_ITEM WHERE ID = #{id} ")
    Item selectOneItem(int id);

}
