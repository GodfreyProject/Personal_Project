package com.example.assignmentwebshopproject.business;

import com.example.assignmentwebshopproject.business.impl.GetAllProductsUseCase;
import com.example.assignmentwebshopproject.dto.GetProductsResponseDTO;
import com.example.assignmentwebshopproject.dto.ProductDTO;
import com.example.assignmentwebshopproject.persistence.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetProductsUseCaseImpl implements GetAllProductsUseCase {
    private final ProductRepository productRepository;

    @Override
    public GetProductsResponseDTO getProducts() {
        List<ProductDTO> products = productRepository.findAll()
                .stream()
                .map(ProductDTOConverter::convertProductToDTO)
                .toList();

        return GetProductsResponseDTO.builder().products(products).build();
    }
}
