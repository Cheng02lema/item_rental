package com.zuitem.service;

import com.zuitem.domain.User;

public interface UserService {
    User getUser(User user);

    User getUserByName(User user);

    Boolean addUser(User user);

    void editPassword(String password, Integer id);
    void delUser(Integer id);

}
