package com.example.assignmentwebshopproject.dto;

import com.example.assignmentwebshopproject.persistence.entity.Category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    private String name;
    private int availablequantity;
    private double price;

   private Category category;

}
