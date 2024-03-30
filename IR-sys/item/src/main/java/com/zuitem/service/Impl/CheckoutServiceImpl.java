package com.zuitem.service.Impl;

import com.zuitem.domain.Checkout;
import com.zuitem.mapper.CheckoutMapper;
import com.zuitem.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckoutServiceImpl implements CheckoutService {
    @Autowired
    private CheckoutMapper checkoutMapper;

    @Override
    public List<Checkout> findAll(String search, String username) {
        return checkoutMapper.findAll(search, username);
    }

    @Override
    public void addCheckout(Checkout checkout) {
        checkoutMapper.addCheckout(checkout);
    }

    @Override
    public void deleteCheckout(List<Integer> list) {
        checkoutMapper.deleteCheckout(list);
    }


}
