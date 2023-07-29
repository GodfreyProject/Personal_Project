package com.example.assignmentwebshopproject.dto;


import com.example.assignmentwebshopproject.persistence.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO {

    private Long id;
    @NotBlank(message = "Product name cannot be empty")
    @Length(max = 50)
    private String name;

//    @NotBlank
//    @Length(max = 20)
    private int  availablequantity;

    private  double price;

    private Category category;
}
