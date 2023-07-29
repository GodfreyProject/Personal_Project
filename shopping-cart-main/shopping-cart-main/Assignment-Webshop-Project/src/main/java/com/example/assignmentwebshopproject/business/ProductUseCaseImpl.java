package com.example.assignmentwebshopproject.business;


import com.example.assignmentwebshopproject.business.impl.ProductUseCase;
import com.example.assignmentwebshopproject.config.exception.ExceptionMessages;
import com.example.assignmentwebshopproject.config.exception.ProductAlreadyExistsException;
import com.example.assignmentwebshopproject.configuration.exception.ExceptionMessage;
import com.example.assignmentwebshopproject.dto.ProductRequestDTO;
import com.example.assignmentwebshopproject.dto.ProductResponseDTO;
import com.example.assignmentwebshopproject.persistence.ProductRepository;
import com.example.assignmentwebshopproject.persistence.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ProductUseCaseImpl implements ProductUseCase {
    private final ProductRepository productRepository;


    @Transactional
    @Override
    public ProductResponseDTO CreateNewProduct(ProductRequestDTO request) {
        if(productRepository.existsByName(request.getName())){
            throw new ProductAlreadyExistsException();
        }
        else if(productRepository.existsByAvailablequantity(request.getAvailablequantity())){
            throw new ProductAlreadyExistsException();
        }

        else if(productRepository.existsByPrice(request.getPrice())){
            throw new ProductAlreadyExistsException();
        }

//
        Product newProduct = Product.builder().name(request.getName()).availablequantity(request.getAvailablequantity()).price(request.getPrice())
                .category(request.getCategory()).build();

        productRepository.save(newProduct);

        return ProductResponseDTO.builder().productId(newProduct.getId()).build();
    }


}

//response("New product has been created successfully.").