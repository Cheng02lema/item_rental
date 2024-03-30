package com.zuitem.service.Impl;

import com.zuitem.domain.Applyout;
import com.zuitem.mapper.ApplyoutMapper;
import com.zuitem.service.ApplyoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ApplyoutServiceImpl implements ApplyoutService {
    @Autowired
    private ApplyoutMapper applyoutMapper;

    @Override
    public List<Applyout> findAll(String search) {
        return applyoutMapper.findAll(search);
    }

    @Override
    public Applyout findByItem_idApplyout(String aoid) {
        return applyoutMapper.findByItem_idApplyout(aoid);
    }
    @Override
    public void updateapplyoutbyitem(Applyout applyout) {applyoutMapper.updateapplyoutbyitem(applyout);
    }

    @Override
    public void addApplyout(Applyout applyout) {
        applyoutMapper.addApplyout(applyout);
    }

    @Override
    public void delapplyout(String item_id) {
        applyoutMapper.delapplyout(item_id);
    }
}
