package com.hai.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * 数据库 商品表实体
 */
public class Item implements Serializable {
    private Integer id;
    private String name;
    private Integer number;
    private Float price;


    private Timestamp startTime;

    private Timestamp endTime;

    private Timestamp createTime;

    public Item() {
    }

    public Item(Integer id, String name, Integer number, Float price, Timestamp startTime, Timestamp endTime, Timestamp createTime) {
        this.id = id;
        this.name = name;
        this.number = number;
        this.price = price;
        this.startTime = startTime;
        this.endTime = endTime;
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }
}
