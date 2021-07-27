package com.shardingsphere.demo.service.impl;

import com.shardingsphere.demo.dao.TUserMapper;
import com.shardingsphere.demo.entity.TUser;
import com.shardingsphere.demo.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private TUserMapper userMapper;

    @Override
    public int insert(TUser record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public int update(TUser record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<TUser> select(Map<String, Object> paramMap) {
        return null;
    }
}
