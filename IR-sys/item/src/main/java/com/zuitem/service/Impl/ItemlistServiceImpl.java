package com.zuitem.service.Impl;

import com.zuitem.domain.Itemlist;
import com.zuitem.mapper.ItemListMapper;
import com.zuitem.service.ItemlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemlistServiceImpl implements ItemlistService {
    @Autowired
    private ItemListMapper itemListMapper;

    @Override
    public List<Itemlist> selectAll(String search, String select) {
        return itemListMapper.selectAll(search, select);
    }

    @Override
    public void addItem(Itemlist item) {itemListMapper.addItem(item);
    }
    @Override
    public void editItem(Itemlist item) {
        itemListMapper.editItem(item);
    }

    @Override
    public void deleteItem(List<Integer> list) {
        itemListMapper.deleteItem(list);
    }


    @Override
    public Itemlist findItem(int itemid) {
        return itemListMapper.findItem(itemid);
    }
}
