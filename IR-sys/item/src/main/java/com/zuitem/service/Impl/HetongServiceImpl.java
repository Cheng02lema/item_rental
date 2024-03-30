package com.zuitem.service.Impl;

import com.zuitem.domain.Hetong;
import com.zuitem.mapper.HetongMapper;
import com.zuitem.service.HetongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HetongServiceImpl implements HetongService {
    @Autowired
    private HetongMapper hetongMapper;

    @Override
    public void addHetong(Hetong hetong) {
        hetongMapper.addHetong(hetong);
    }

    @Override
    public Hetong findhetong(String item_id) {
        return hetongMapper.findhetong(item_id);
    }

    @Override
    public void delHetong(String item_id) {
        hetongMapper.delHetong(item_id);
    }

    @Override
    public void editHetong(Hetong hetong) {
        hetongMapper.editHetong(hetong);
    }
}
