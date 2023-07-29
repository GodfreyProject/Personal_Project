package com.example.assignmentwebshopproject.businessimpl;

import com.example.assignmentwebshopproject.business.ProductUseCaseImpl;
import com.example.assignmentwebshopproject.dto.ProductRequestDTO;
import com.example.assignmentwebshopproject.persistence.ProductRepository;
import com.example.assignmentwebshopproject.persistence.entity.Category;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ProductUseCaseImplTest {

    @Mock
    private ProductRepository productRepositoryMock;

    @InjectMocks
    private ProductUseCaseImpl productUseCase;

    @Test
    void ShouldcreateNewProduct() {
        ProductRequestDTO suits = ProductRequestDTO.builder().name("Turkish-Suits").availablequantity(300).price(250.75)
                .category(Category.Business_Attire).build();
    }


    @Test
    void ShouldcreateAnotherNewProduct() {
        ProductRequestDTO winter = ProductRequestDTO.builder().name("Winter-Jacket").availablequantity(250).price(15.60)
                .category(Category.Winter).build();
    }
}