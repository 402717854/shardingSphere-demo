package com.shardingsphere.demo.service.impl;

import com.shardingsphere.demo.dao.TOrderMapper;
import com.shardingsphere.demo.entity.TOrder;
import com.shardingsphere.demo.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private TOrderMapper orderMapper;


    @Override
    public int insert(TOrder record) {
        return orderMapper.insert(record);
    }

    @Override
    public int update(TOrder record) {
        return 0;
    }

    @Override
    public List<TOrder> select(Map<String, Object> paramMap) {
        return null;
    }
}
