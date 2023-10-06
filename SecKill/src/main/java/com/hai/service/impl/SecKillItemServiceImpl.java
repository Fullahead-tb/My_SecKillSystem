package com.hai.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.digest.DigestUtil;
import com.hai.dao.RedisDao;
import com.hai.dao.SecKillItemDao;
import com.hai.entity.Item;
import com.hai.service.SecKillItemService;
import com.hai.util.SecKillURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Service
public class SecKillItemServiceImpl  implements SecKillItemService {

    @Autowired
    SecKillItemDao itemDao;

    @Autowired
    RedisDao redisDao;


    public SecKillItemServiceImpl(SecKillItemDao dao) {
        this.itemDao = dao;
    }

    public SecKillItemServiceImpl() {
    }

    public void setDao(SecKillItemDao dao) {
        this.itemDao = dao;
    }

    @Override
    public List<Item> selectItemList() {

        List<Item> itemList = itemDao.selectItemList();

//        for (Item item:itemList){
//            Date startTime = item.getStartTime();
//            Timestamp timestamp = new Timestamp(startTime.getTime());
//
//        }

        return itemList;

    }

    @Override
    public Item selectOneItem(int id) {
        return itemDao.selectOneItem(id);
    }

    @Override
    public SecKillURL getURL(int id) {


        String idStr = new String(Integer.toString(id));

        //判断redis中是否存在id对应的URL信息
        Item item = (Item) redisDao.get(idStr);
        SecKillURL url = new SecKillURL();

        if (ObjectUtil.isEmpty(item)){

            //没有就从数据库中获取再存入redis
            item = itemDao.selectOneItem(id);

            //若数据库中没有该商品信息
            if (ObjectUtil.isEmpty(item)){
                url.setEnable(false);
                url.setProductId(id);
            }

            redisDao.set(idStr,item);
        }

            //redis中有商品信息
            Timestamp startTime = item.getStartTime();

            Timestamp endTime = item.getEndTime();

            Timestamp now = new Timestamp(new Date().getTime());

            //判断商品是否在抢购时间之间

            if (now.getTime() < startTime.getTime() || now.getTime()>endTime.getTime()){
                //不在抢购时间内   非法请求不予考虑
                url = new SecKillURL();
                url.setEnable(false);
                url.setProductId(id);
                url.setStart(startTime.getTime());
                url.setEnd(endTime.getTime());
                url.setNow(now.getTime());
                return url;
            }
            //到达抢购时间内，组装URL并返回
            String md5 = getMD5(item.getId());
            url = new SecKillURL();
            url.setEnable(true);
            url.setProductId(id);
            url.setMd5(md5);
            url.setStart(startTime.getTime());
            url.setEnd(endTime.getTime());
            url.setNow(now.getTime());

            return url;
    }

    private final String mixnKey = "SAD23*(FY*@";
    private String getMD5(int productId){
        String idStr = Integer.toString(productId);
        String source = idStr+"|" +mixnKey;
        String md5 = DigestUtil.md5Hex(source);
        return md5;
    }
}
