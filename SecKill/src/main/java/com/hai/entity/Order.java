package com.hai.entity;

import java.util.Date;

/**
 * 数据库 订单表实体
 */
public class Order {

    private Integer id;
    private Integer itemId;
    private Integer userId;
    private Integer state;
    private Date createTime;

    public Order() {
    }

    public Order(Integer id, Integer itemId, Integer userId, Integer state, Date createTime) {
        this.id = id;
        this.itemId = itemId;
        this.userId = userId;
        this.state = state;
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", userId=" + userId +
                ", state=" + state +
                ", createTime=" + createTime +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
