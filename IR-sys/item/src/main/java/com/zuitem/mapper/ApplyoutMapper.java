package com.zuitem.mapper;

import com.zuitem.domain.Applyout;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ApplyoutMapper {
    List<Applyout> findAll(@Param("search") String search);

    Applyout findByItem_idApplyout(@Param("aoid") String aoid);

    void updateapplyoutbyitem(Applyout applyout);

    void addApplyout(Applyout applyout);

    void delapplyout(@Param("item_id") String item_id);
}
