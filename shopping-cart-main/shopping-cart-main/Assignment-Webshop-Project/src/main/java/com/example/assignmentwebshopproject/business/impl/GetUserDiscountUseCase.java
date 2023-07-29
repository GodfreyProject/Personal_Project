package com.example.assignmentwebshopproject.business.impl;

import com.example.assignmentwebshopproject.persistence.entity.ShoppingCart;

import java.util.List;

public interface GetUserDiscountUseCase {

    public Double getUserDiscount(List<ShoppingCart> shoppingCartList);
}
