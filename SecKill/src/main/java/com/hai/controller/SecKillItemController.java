package com.hai.controller;

import cn.hutool.db.handler.StringHandler;
import com.hai.entity.Item;
import com.hai.exception.LoginErrorException;
import com.hai.service.impl.SecKillItemServiceImpl;
import com.hai.util.R;
import com.hai.util.SecKillURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

@Controller
public class SecKillItemController {

    @Autowired
    SecKillItemServiceImpl itemService;


    @RequestMapping("/commodityList")
    //获取所有秒杀商品信息
    public ModelAndView commodityList(){

       try{
           List<Item> itemList = itemService.selectItemList();
           ModelAndView mv = new ModelAndView();

           if (itemList != null){

               mv.addObject("itemList",itemList);
               mv.setViewName("secKill_list");

           }

           return mv;

       }catch (Exception e){
           e.printStackTrace();
           throw new LoginErrorException("获取失败!");
       }
    }

    @RequestMapping("/productDetails")
    public String getProductDetails(int id, Model model){

        Item item = itemService.selectOneItem(id);

        long time = item.getStartTime().getTime();
        System.out.println(time);

        model.addAttribute("item",item);

        return "productDetails";
    }


    @RequestMapping("/getServerTime")
    @ResponseBody
    public R getServerTime(){
        Date date = new Date();
        R<Long> r = new R(true,"ok",date.getTime());
        return r;
    }

    @RequestMapping("/buy")
    @ResponseBody
    public R<String> buy(int id){

        System.out.println(id);

        R r = new R(true,"ok","正在抢购中！");

        return r;

    }

    @RequestMapping(path = "/getURL",method = RequestMethod.POST)
    @ResponseBody
    public R<SecKillURL> getURL(int id){

        System.out.println("抢购正在开始，正在返回URL");
        System.out.println("productId="+id);
       try{
           SecKillURL url = itemService.getURL(id);


           R r = new R(true,"ok",url);


           return r;

       } catch (Exception e){

           return new R(false,e.getMessage(),null);
       }

    }


}
