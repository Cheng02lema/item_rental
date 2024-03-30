package com.zuitem.service.Impl;

import com.zuitem.domain.Paid;
import com.zuitem.mapper.PaidMapper;
import com.zuitem.service.PaidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaidServiceImpl implements PaidService {
    @Autowired
    private PaidMapper paidMapper;

    @Override
    public List<Paid> findAll(String search, String date, String date1, Integer id) {
        return paidMapper.findAll(search, date, date1, id);
    }

    @Override
    public void addPaid(Paid paid) {
        paidMapper.addPaid(paid);
    }

    @Override
    public void deletePaid(List<Integer> list) {
        paidMapper.deletePaid(list);
    }
}
