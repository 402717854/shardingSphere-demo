package com.shardingsphere.demo.dao;

import com.shardingsphere.demo.entity.TLog;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TLogMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TLog record);

    int insertSelective(TLog record);

    TLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TLog record);

    int updateByPrimaryKey(TLog record);
}