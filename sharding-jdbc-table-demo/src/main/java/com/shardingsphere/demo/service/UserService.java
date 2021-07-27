package com.shardingsphere.demo.service;

import com.shardingsphere.demo.entity.TUser;

import java.util.List;
import java.util.Map;

public interface UserService {
    int insert(TUser record);

    int update(TUser record);

    List<TUser> select(Map<String,Object> paramMap);
}
