package com.zuitem.mapper;

import com.zuitem.domain.Topaid;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TopaidMapper {
    List<Topaid> findtopaid(@Param("search") String search);
    List<Topaid> findtopaidByid(@Param("id") Integer id);
    void addtopaid(Topaid topaid);

    Topaid findtopaidByItem_id(@Param("itemid") String itemid);

    void deletetopaid(@Param("itemid") String itemid);

}
