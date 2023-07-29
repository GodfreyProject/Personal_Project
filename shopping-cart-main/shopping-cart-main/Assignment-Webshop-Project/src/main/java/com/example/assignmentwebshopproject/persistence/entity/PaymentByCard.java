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
@Table(name = "byCard")
public class PaymentByCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "CardId")
    private Long id;


    private String address;

    private String zipcode;

    private String ibanCardno;

    private double totalAmount;


    private String date;

    public Long getId() {
        return id;
    }

    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;


}
