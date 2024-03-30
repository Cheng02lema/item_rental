package com.zuitem.service;

import com.zuitem.domain.User;
import com.zuitem.domain.Userlist;

import java.util.List;

public interface UserlistService {
    Userlist findByUserid(Integer userid);
    void editUser(Userlist userlist);
    List<Userlist> findAll();
    void addUser(User user);
    void delUser(Integer id);
    Userlist findByName(String name);

}
