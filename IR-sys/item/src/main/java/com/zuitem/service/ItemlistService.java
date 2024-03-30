package com.zuitem.service;

import com.zuitem.domain.Itemlist;

import java.util.List;

public interface ItemlistService {
    List<Itemlist> selectAll(String search, String select);

    void addItem(Itemlist item);

    void editItem(Itemlist item);

    void deleteItem(List<Integer> list);

    Itemlist findItem(int itemid);
}
