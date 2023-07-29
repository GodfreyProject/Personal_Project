package com.example.assignmentwebshopproject.persistence.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "stock")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "productId")
    private Long id;

    @NotBlank(message = "Product item cannot be empty")
    @Column(name = "name")
    @Length(max = 50)
    private String name;

    @NonNull
    private int availablequantity;
    private double price;

    @Enumerated(EnumType.STRING)
    @Column(name="category")
    private Category category;
}
