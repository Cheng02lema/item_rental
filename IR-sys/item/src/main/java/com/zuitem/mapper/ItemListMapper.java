package com.zuitem.mapper;

import com.zuitem.domain.Itemlist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ItemListMapper {
    List<Itemlist> selectAll(@Param("search") String search, @Param("select") String select);
    void addItem(Itemlist iteml);
    void editItem(Itemlist iteml);
    void deleteItem(@Param("list") List<Integer> list);
    Itemlist findItem(@Param("itemid") int itemid);
}
