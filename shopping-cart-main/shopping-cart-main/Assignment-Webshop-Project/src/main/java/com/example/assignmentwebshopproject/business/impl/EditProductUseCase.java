package com.example.assignmentwebshopproject.business.impl;


import com.example.assignmentwebshopproject.dto.EditProductRequestDTO;
import com.example.assignmentwebshopproject.persistence.entity.Product;

public interface EditProductUseCase {
    Product EditProduct(EditProductRequestDTO request, Long Id);
}
