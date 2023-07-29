package com.example.assignmentwebshopproject.businessimpl;



import com.example.assignmentwebshopproject.business.ProductDTOConverter;
import com.example.assignmentwebshopproject.dto.ProductDTO;
import com.example.assignmentwebshopproject.persistence.entity.Category;
import com.example.assignmentwebshopproject.persistence.entity.Product;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProductDTOConverterTest {

    @Test
    void shouldConvertProductToDTO() {
        Product sneakers = Product.builder().id(1l).name("Sneakers").availablequantity(125).price(105.74)
                .category(Category.Casual)
                .build();

        ProductDTO actual = ProductDTOConverter.convertProductToDTO(sneakers);

        ProductDTO expected = ProductDTO.builder().id(1l).name("Sneakers").availablequantity(125).price(105.74)

                .category(Category.Casual).build();

        assertEquals(expected, actual);
    }

    @Test
    void shouldConvertProductToDTO2() {
        Product suits = Product.builder().id(2l).name("Italian-Suits").availablequantity(200).price(390.75)
                .category(Category.Business_Attire)
                .build();

        ProductDTO actual = ProductDTOConverter.convertProductToDTO(suits);

        ProductDTO expected = ProductDTO.builder().id(2l).name("Italian-Suits").availablequantity(200).price(390.75)

                .category(Category.Business_Attire).build();

        assertEquals(expected, actual);
    }
}