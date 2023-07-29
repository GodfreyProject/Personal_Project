package com.example.assignmentwebshopproject.business.impl;

import com.example.assignmentwebshopproject.configuration.exception.ProductNotFoundWithThatIDException;
import com.example.assignmentwebshopproject.dto.ProductDTO;

import java.util.Optional;

public interface GetProductUseCase {
    Optional<ProductDTO> getProduct(Long id) throws ProductNotFoundWithThatIDException;
}
