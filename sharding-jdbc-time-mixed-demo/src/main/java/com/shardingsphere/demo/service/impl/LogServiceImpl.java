package com.shardingsphere.demo.service.impl;

import com.shardingsphere.demo.dao.TLogMapper;
import com.shardingsphere.demo.entity.TLog;
import com.shardingsphere.demo.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class LogServiceImpl implements LogService {

    @Autowired(required = true)
    private TLogMapper logMapper;
    @Override
    public int insert(TLog record) {
        return logMapper.insert(record);
    }

    @Override
    public int updateByPrimaryKey(TLog record) {
        return logMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<TLog> select(Map<String, Object> paramMap) {
        return null;
    }
}
