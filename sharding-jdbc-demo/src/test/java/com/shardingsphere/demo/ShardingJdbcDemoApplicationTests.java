package com.shardingsphere.demo;

import com.shardingsphere.demo.entity.TOrder;
import com.shardingsphere.demo.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ShardingJdbcDemoApplicationTests {

    @Resource
    private OrderService orderService;

    @Test
    public void testInsert() {
        TOrder tOrder = new TOrder();
        tOrder.setUserId(1L);
        tOrder.setOrderName("订单名称");
        tOrder.setCreateTime(new Date());
        orderService.insert(tOrder);
    }

}
