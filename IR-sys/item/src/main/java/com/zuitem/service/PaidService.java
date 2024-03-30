package com.zuitem.service;

import com.zuitem.domain.Paid;

import java.util.List;

public interface PaidService {
    List<Paid> findAll(String search, String date, String date1, Integer id);

    void addPaid(Paid paid);

    void deletePaid(List<Integer> list);

}
