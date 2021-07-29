package com.shardingsphere.demo;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.shardingsphere.demo.entity.TLog;
import com.shardingsphere.demo.service.LogService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ShardingJdbcTimeDemoApplicationTests {

    @Autowired
    private LogService logService;

    @Test
    public void insert(){
        TLog tLog = new TLog();
        tLog.setName("日志名称");
        String dateStr = "2021-02-01 12:12:12";
        DateTime parse = DateUtil.parse(dateStr);
        tLog.setEventTime(parse);
        logService.insert(tLog);
    }

}
