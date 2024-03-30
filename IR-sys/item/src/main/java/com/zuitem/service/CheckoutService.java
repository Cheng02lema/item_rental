package com.zuitem.service;

import com.zuitem.domain.Checkout;

import java.util.List;

public interface CheckoutService {
    List<Checkout> findAll(String search,String username);

    void addCheckout(Checkout checkout);
    void deleteCheckout(List<Integer> list);
}
