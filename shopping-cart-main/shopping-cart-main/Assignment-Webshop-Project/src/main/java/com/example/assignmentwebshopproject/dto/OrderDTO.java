package com.example.assignmentwebshopproject.dto;


import com.example.assignmentwebshopproject.persistence.entity.ShoppingCart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OrderDTO {

//    public OrderDTO getOrderId() {
//        return orderId;
//    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    private Long orderId;
    private String orderDescription;
    private List<ShoppingCart> cartItems;

    //private OrderDTO order;

    private  UserDTO user;

    public Double getTotalAmount() {
        return TotalAmount;
    }

    private Double TotalAmount;



    public String getOrderDescription() {
        return orderDescription;
    }


    public void setOrderDescription(String orderDescription) {
        this.orderDescription = orderDescription;
    }

    public List<ShoppingCart> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<ShoppingCart> cartItems) {
        this.cartItems = cartItems;
    }




}
