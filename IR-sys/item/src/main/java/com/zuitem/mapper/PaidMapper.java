package com.zuitem.mapper;

import com.zuitem.domain.Paid;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PaidMapper {
    List<Paid> findAll(@Param("search") String search, @Param("date") String date, @Param("date1") String date1, @Param("id") Integer id);

    void addPaid(Paid paid);

    void deletePaid(List<Integer> list);
}
