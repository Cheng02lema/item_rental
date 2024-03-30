package com.zuitem.mapper;

import com.zuitem.domain.Hetong;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HetongMapper {
    void  addHetong(Hetong hetong);
    Hetong findhetong(@Param("item_id") String item_id);
    void delHetong(@Param("item_id") String item_id);
    void editHetong(Hetong hetong);
}
