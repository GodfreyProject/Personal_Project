package com.example.assignmentwebshopproject.business.impl;

import com.example.assignmentwebshopproject.dto.ProductRequestDTO;
import com.example.assignmentwebshopproject.dto.ProductResponseDTO;


public interface ProductUseCase {
    ProductResponseDTO CreateNewProduct(ProductRequestDTO request);
}
