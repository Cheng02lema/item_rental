package com.zuitem.service;

import com.zuitem.domain.Zulist;

import java.util.List;

public interface ZulistService {
    List<Zulist> findAll(String search,String username);

    Zulist findByItem_idZulist(String item_id);


    void deleteByItem_id(String item_id);
    void addzulist(Zulist zulist);

}
