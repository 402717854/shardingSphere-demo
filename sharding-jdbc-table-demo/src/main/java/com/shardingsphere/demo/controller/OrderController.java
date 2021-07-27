package com.shardingsphere.demo.controller;

import com.shardingsphere.demo.entity.TOrder;
import com.shardingsphere.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/insert")
    public void insert() {
        TOrder tOrder = new TOrder();
        tOrder.setUserId(1L);
        tOrder.setOrderName("订单名称");
        tOrder.setCreateTime(new Date());
        orderService.insert(tOrder);
    }
}
