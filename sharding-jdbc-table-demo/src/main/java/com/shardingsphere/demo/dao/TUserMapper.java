package com.shardingsphere.demo.dao;

import com.shardingsphere.demo.entity.TUser;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserMapper {

    int deleteByPrimaryKey(Long id);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);
}