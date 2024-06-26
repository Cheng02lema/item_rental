package com.zuitem.mapper;

import com.zuitem.domain.Checkout;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CheckoutMapper {
    List<Checkout> findAll(@Param("search") String search,@Param("username") String username);
    void addCheckout(Checkout checkout);
    void deleteCheckout(@Param("list") List<Integer> list);
}
