package com.hai.service;

import com.hai.entity.Item;
import com.hai.util.SecKillURL;

import java.util.List;

public interface SecKillItemService {


    List<Item> selectItemList();

    Item selectOneItem(int id);

    SecKillURL getURL(int id);
}
