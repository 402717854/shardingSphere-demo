package com.shardingsphere.demo.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.shardingsphere.demo.entity.TLog;
import com.shardingsphere.demo.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {

    @Autowired
    private LogService logService;

    @RequestMapping("/insert")
    public void insert(){
        TLog tLog = new TLog();
        tLog.setName("日志名称");
        String dateStr = "2017-01-01 12:12:12";
        DateTime parse = DateUtil.parse(dateStr);
        tLog.setEventTime(parse);
        logService.insert(tLog);
    }
}
