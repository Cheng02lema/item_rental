package com.zuitem.service.Impl;

import com.zuitem.domain.Zulist;
import com.zuitem.mapper.ZulistMapper;
import com.zuitem.service.ZulistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZulistServiceImpl implements ZulistService {
    @Autowired
    private ZulistMapper zulistMapper;

    @Override
    public List<Zulist> findAll(String search, String username) {
        return zulistMapper.findAll(search, username);
    }

    @Override
    public Zulist findByItem_idZulist(String item_id) {
        return zulistMapper.findByItem_idZulist(item_id);
    }

    @Override
    public void deleteByItem_id(String item_id) {
        zulistMapper.deleteByItem_id(item_id);
    }

    @Override
    public void addzulist(Zulist zulist) {
        zulistMapper.addzulist(zulist);
    }
}
