package com.example.assignmentwebshopproject.business;

import com.example.assignmentwebshopproject.config.exception.ProductAlreadyExistsException;
import com.example.assignmentwebshopproject.dto.ProductRequestDTO;
import com.example.assignmentwebshopproject.persistence.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProductUseCaseImplTest {

    @Mock
    private ProductRepository productRepositoryMock;


    @InjectMocks
    private ProductUseCaseImpl productUseCaseMock;


    @Test
    void createProduct_shouldThrowException_whenProductNameAlreadyExists() {
        when(productRepositoryMock.existsByName("Sneakers")).thenReturn(true);

        ProductRequestDTO request = ProductRequestDTO.builder()
                .name("Sneakers")
                .availablequantity(45)
                .build();

        ProductAlreadyExistsException exceptionThrown = assertThrows(ProductAlreadyExistsException.class, () -> {
            productUseCaseMock.CreateNewProduct(request);
        });

        assertEquals("400 BAD_REQUEST \"PRODUCT_ALREADY_EXISTS\"", exceptionThrown.getMessage());
        verify(productRepositoryMock).existsByName("Sneakers");
    }


    @Test
    void createProduct_shouldThrowException_whenProductAvailableQuantityAlreadyExists() {
        when(productRepositoryMock.existsByAvailablequantity(45)).thenReturn(true);

        ProductRequestDTO request = ProductRequestDTO.builder()
                .name("Sneakers")
                .availablequantity(45)
                .build();

        ProductAlreadyExistsException exceptionThrown = assertThrows(ProductAlreadyExistsException.class, () -> {
            productUseCaseMock.CreateNewProduct(request);
        });

        assertEquals("400 BAD_REQUEST \"PRODUCT_ALREADY_EXISTS\"", exceptionThrown.getMessage());
        verify(productRepositoryMock).existsByAvailablequantity(45);
    }

    @Test
    void createProduct_shouldThrowException_whenProductPriceAlreadyExists() {
        when(productRepositoryMock.existsByPrice(125.60)).thenReturn(true);

        ProductRequestDTO request = ProductRequestDTO.builder()
                .name("Sneakers")
                .price(125.60)
                .build();

        ProductAlreadyExistsException exceptionThrown = assertThrows(ProductAlreadyExistsException.class, () -> {
            productUseCaseMock.CreateNewProduct(request);
        });

        assertEquals("400 BAD_REQUEST \"PRODUCT_ALREADY_EXISTS\"", exceptionThrown.getMessage());
        verify(productRepositoryMock).existsByPrice(125.60);
    }


}