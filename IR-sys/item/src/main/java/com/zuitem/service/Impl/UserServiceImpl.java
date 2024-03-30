package com.zuitem.service.Impl;

import com.zuitem.domain.User;
import com.zuitem.mapper.UserMapper;
import com.zuitem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUser(User user) {
        return userMapper.getUser(user);
    }
    @Override
    public User getUserByName(User user) {
        return userMapper.getUserByName(user);
    }

    @Override
    public Boolean addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public void editPassword(String password, Integer id) {
        userMapper.editPassword(password, id);
    }

    @Override
    public void delUser(Integer id) {
        userMapper.delUser(id);
    }





}
