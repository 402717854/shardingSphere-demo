package com.shardingsphere.demo.service;

import com.shardingsphere.demo.entity.TOrder;

import java.util.List;
import java.util.Map;

public interface OrderService {

    int insert(TOrder record);

    int update(TOrder record);

    List<TOrder> select(Map<String,Object> paramMap);
}
