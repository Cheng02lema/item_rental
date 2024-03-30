package com.zuitem.service;

import com.zuitem.domain.Apply;

import java.util.List;

public interface ApplyService {
    List<Apply> findAll(String search);


    Apply findByItem_id(String item_id);



    void deleteByItem_id(String item_id);
    void addApply(Apply apply);


}
