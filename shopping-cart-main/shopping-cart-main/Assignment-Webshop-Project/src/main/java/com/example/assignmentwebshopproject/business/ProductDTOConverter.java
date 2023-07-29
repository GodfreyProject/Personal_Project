package com.example.assignmentwebshopproject.business;

import com.example.assignmentwebshopproject.dto.ProductDTO;
import com.example.assignmentwebshopproject.persistence.entity.Product;


public final class ProductDTOConverter {
    private ProductDTOConverter(){
    }

    public static ProductDTO convertProductToDTO(Product product){
        return ProductDTO.builder().id(product.getId()).name(product.getName()).availablequantity(product.getAvailablequantity())
                .price(product.getPrice())
                .category(product.getCategory()).build();

    }
}
