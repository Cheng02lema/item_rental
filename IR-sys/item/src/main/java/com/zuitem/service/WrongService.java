package com.zuitem.service;

import com.zuitem.domain.Wrong;

import java.util.List;


public interface WrongService {
    List<Wrong> findAll(String user_id);

    Wrong findWrongByid(String id);

    void addWrong(Wrong wrong);

    void delWrong(Integer id);

}
