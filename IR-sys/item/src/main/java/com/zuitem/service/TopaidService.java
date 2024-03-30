package com.zuitem.service;

import com.zuitem.domain.Topaid;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TopaidService {
    List<Topaid> findtopaid(String search);
    List<Topaid> findtopaidByid(@Param("id") Integer id);
    void addtopaid(Topaid topaid);
    Topaid findtopaidByItem_id(String ItemId);
    void deletetopaid(String itemid);
}
