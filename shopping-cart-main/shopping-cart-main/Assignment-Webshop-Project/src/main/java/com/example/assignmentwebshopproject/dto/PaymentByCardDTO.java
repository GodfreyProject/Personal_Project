package com.example.assignmentwebshopproject.dto;

import com.example.assignmentwebshopproject.persistence.entity.Order;
import com.example.assignmentwebshopproject.persistence.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor

public class PaymentByCardDTO {


    private Long id;

    private  String firstname;
    private String address;

    private String zipcode;


    private String ibanCardno;

    private double amount;

    private String date;


    private OrderDTO order;

    public Long getId() {
        return id;
    }


    private UserDTO user;


}
