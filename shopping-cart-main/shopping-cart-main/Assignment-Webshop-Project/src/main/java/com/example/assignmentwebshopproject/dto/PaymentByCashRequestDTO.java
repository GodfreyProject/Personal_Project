package com.example.assignmentwebshopproject.dto;

import com.example.assignmentwebshopproject.persistence.entity.Order;
import com.example.assignmentwebshopproject.persistence.entity.ShoppingCart;
import com.example.assignmentwebshopproject.persistence.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PaymentByCashRequestDTO {


    private Long id;


    private String address;

    private String zipcode;

//    public double getTotalAmount() {
//        return totalAmount;
//    }

    private double totalAmount;

    private String date;



    private Long orderId;

    private Long userId;

//    public double getTotalAmount() {
//        List<ShoppingCart> cartItems = new ArrayList<>();
//        Double totalAmount = 0.0;
//        for (
//                ShoppingCart item : cartItems) {
//            totalAmount += item.getAmount() * item.getQuantity();
//        }
//        return totalAmount;
//
//    }

}
