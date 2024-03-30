package com.zuitem.service.Impl;

import com.zuitem.domain.Apply;
import com.zuitem.mapper.ApplyMapper;
import com.zuitem.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyServiceImpl implements ApplyService {
    @Autowired
    private ApplyMapper applyMapper;

    @Override
    public List<Apply> findAll(String search) {
        return applyMapper.findAll(search);
    }

    @Override
    public Apply findByItem_id(String item_id) {
        return applyMapper.findByItem_id(item_id);
    }

    @Override
    public void deleteByItem_id(String item_id) {
        applyMapper.deleteByItem_id(item_id);
    }

    @Override
    public void addApply(Apply apply) {
        applyMapper.addApply(apply);
    }
}
