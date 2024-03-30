package com.zuitem.service.Impl;

import com.zuitem.domain.Topaid;
import com.zuitem.mapper.TopaidMapper;
import com.zuitem.service.TopaidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopaidServiceImpl implements TopaidService {
    @Autowired
    private TopaidMapper topaidMapper;

    @Override
    public List<Topaid> findtopaid(String search) {
        return topaidMapper.findtopaid(search);
    }

    @Override
    public List<Topaid> findtopaidByid(Integer id) {
        return topaidMapper.findtopaidByid(id);
    }

    @Override
    public void addtopaid(Topaid topaid) {
        topaidMapper.addtopaid(topaid);
    }


    @Override
    public Topaid findtopaidByItem_id(String ItemId) {
        return topaidMapper.findtopaidByItem_id(ItemId);
    }


    @Override
    public void deletetopaid(String itemid) {
        topaidMapper.deletetopaid(itemid);
    }
}
