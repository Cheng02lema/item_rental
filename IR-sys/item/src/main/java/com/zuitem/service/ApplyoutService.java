package com.zuitem.service;

import com.zuitem.domain.Applyout;

import java.util.List;

public interface ApplyoutService {
    List<Applyout> findAll(String search);
    Applyout findByItem_idApplyout(String aoid);
    void updateapplyoutbyitem(Applyout applyout);
    void addApplyout(Applyout applyout);
    void delapplyout(String item_id);


}
