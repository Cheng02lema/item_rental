package com.zuitem.mapper;

import com.zuitem.domain.Zulist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ZulistMapper {
    List<Zulist> findAll(@Param("search") String search, @Param("username") String username);

    Zulist findByItem_idZulist(@Param("item_id") String item_id);

    void deleteByItem_id(@Param("item_id") String item_id);

    void addzulist(Zulist zulist);
}
