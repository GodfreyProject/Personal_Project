package com.example.assignmentwebshopproject.dto;


import com.example.assignmentwebshopproject.persistence.entity.ShoppingCart;
import lombok.*;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CheckoutOrderRequestDTO {

    //private  Long OrderId;
    private String orderDescription;
    private List<ShoppingCart> cartItems;




    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    private Long userId;


//    private String date;
    private String OrderDescription;


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
