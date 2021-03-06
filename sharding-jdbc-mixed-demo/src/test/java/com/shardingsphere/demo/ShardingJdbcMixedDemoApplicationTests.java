package com.shardingsphere.demo;

import com.shardingsphere.demo.entity.TUser;
import com.shardingsphere.demo.service.OrderService;
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
public class ShardingJdbcMixedDemoApplicationTests {

    @Autowired
    private UserService userService;
    @Resource
    private OrderService orderService;

    @Test
    public void insert() {
        TUser user = new TUser();
        user.setOrderId(122L);
        user.setName("用户名称");
        user.setCreateTime(new Date());
        int insert = userService.insert(user);
        System.out.println(insert);
    }

}
