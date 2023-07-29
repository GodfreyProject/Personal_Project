package com.example.assignmentwebshopproject.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "byCash")
public class PaymentByCash {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "CashId")
    private Long id;


    private String address;

    private String zipcode;




    private  double totalAmount;

    private String date;




    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;
}
