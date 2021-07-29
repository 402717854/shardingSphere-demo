package com.shardingsphere.demo;

import com.shardingsphere.demo.entity.TOrder;
import com.shardingsphere.demo.entity.TUser;
import com.shardingsphere.demo.service.OrderService;
import com.shardingsphere.demo.service.RetryService;
import com.shardingsphere.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ShardingJdbcTableDemoApplicationTests {

    @Autowired
    private UserService userService;
    @Resource
    private OrderService orderService;
    @Autowired
    private RetryService retryService;

    @Test
    public void insert() {
        TUser user = new TUser();
        user.setName("用户名称");
        user.setCreateTime(new Date());
        int insert = userService.insert(user);
        System.out.println(insert);
    }

    @Test
    public void testInsert() {
        TOrder tOrder = new TOrder();
        tOrder.setUserId(1L);
        tOrder.setOrderName("订单名称");
        tOrder.setCreateTime(new Date());
        orderService.insert(tOrder);
    }
    @Test
    public void testRetry() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            retryService.retryCircuitBreaker("3");
        }
        for (int i = 0; i < 3; i++) {
            retryService.retryCircuitBreaker("1");
            Thread.sleep(5000);
        }
        Thread.sleep(10000);
        retryService.retryCircuitBreaker("3");
        retryService.retryCircuitBreaker("1");
    }
    @Test
    public void testRetry2() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            retryService.retryCircuitBreaker("3");
            Thread.sleep(4000);
        }
        retryService.retryCircuitBreaker("1");
    }
}
