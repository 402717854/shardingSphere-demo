package com.shardingsphere.demo;

import com.shardingsphere.demo.entity.TUser;
import com.shardingsphere.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ShardingJdbcTableDemoApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void insert() {
        TUser user = new TUser();
        user.setName("用户名称");
        user.setCreateTime(new Date());
        int insert = userService.insert(user);
        System.out.println(insert);
    }
}
