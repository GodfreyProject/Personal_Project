package com.example.assignmentwebshopproject.dto;

import com.example.assignmentwebshopproject.persistence.entity.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditProductRequestDTO {
    private Long id;

    @NotBlank(message = "Email cannot be empty")
//    @Length(max = 50)
    private String name;

    @NotNull
//    @Length(max = 50)
    private int availablequantity;

    @NotNull
//    @Length(max = 50)
    private double price;

    @Enumerated(EnumType.STRING)
    @Column(name="category")
    @NotNull
//    @Length(max = 50)
    private Category category;



}
