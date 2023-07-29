package com.example.assignmentwebshopproject.dto;

import com.example.assignmentwebshopproject.persistence.entity.Order;
import com.example.assignmentwebshopproject.persistence.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PaymentByCashDTO {


    private Long id;

    private  String firstname;
    private String address;

    private String zipcode;

    private double cartTotal;

    private String date;



    private OrderDTO order;



    private UserDTO user;
}
