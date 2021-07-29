package com.shardingsphere.demo.service;

import com.shardingsphere.demo.entity.TLog;

import java.util.List;
import java.util.Map;

public interface LogService {

    int insert(TLog record);

    int updateByPrimaryKey(TLog record);

    List<TLog> select(Map<String,Object> paramMap);
}
