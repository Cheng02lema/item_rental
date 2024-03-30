package com.zuitem.mapper;

import com.zuitem.domain.Apply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ApplyMapper {
    List<Apply> findAll(@Param("search") String search);

    Apply findByItem_id(@Param("item_id") String item_id);

    void deleteByItem_id(@Param("item_id") String item_id);

    void addApply(Apply apply);
}
