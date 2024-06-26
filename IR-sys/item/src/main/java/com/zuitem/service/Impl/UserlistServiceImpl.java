package com.zuitem.service.Impl;

import com.zuitem.domain.User;
import com.zuitem.domain.Userlist;
import com.zuitem.mapper.UserlistMapper;
import com.zuitem.service.UserlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserlistServiceImpl implements UserlistService {
    @Autowired
    private UserlistMapper userlistMapper;

    @Override
    public Userlist findByUserid(Integer userid) {
        return userlistMapper.findByUserid(userid);
    }

    @Override
    public void editUser(Userlist userlist) {
        userlistMapper.editUser(userlist);
    }

    @Override
    public List<Userlist> findAll() {
        return userlistMapper.findAll();
    }

    @Override
    public void addUser(User user) {
        userlistMapper.addUser(user);
    }

    @Override
    public void delUser(Integer id) {
        userlistMapper.delUser(id);
    }

    @Override
    public Userlist findByName(String name) {
        return userlistMapper.findByName(name);
    }
}
