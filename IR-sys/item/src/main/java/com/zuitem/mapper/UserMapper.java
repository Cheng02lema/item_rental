package com.zuitem.mapper;

import com.zuitem.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User getUser(User user);
    User getUserByName(User user);
    Boolean addUser(User user);
    void editPassword(@Param("password") String password,@Param("id") Integer id);
    void delUser(@Param("id") Integer id);

}
