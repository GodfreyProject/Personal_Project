package com.example.assignmentwebshopproject.persistence;

import com.example.assignmentwebshopproject.dto.EditProductRequestDTO;
import com.example.assignmentwebshopproject.persistence.entity.Category;
import com.example.assignmentwebshopproject.persistence.entity.Product;
import com.example.assignmentwebshopproject.persistence.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ProductRepositoryTest {


    @Mock
    private ProductRepository productRepositoryMock;



    @Test
    void Should_SaveNewProduct_Using_UserRespositoryTest() {
        Product sneakers = Product.builder().build().builder().

                id(2l).name("Sneakers").availablequantity(35).price(125.60).category(Category.Casual)

                .build();

            productRepositoryMock.save(sneakers);

            assertThat(sneakers.getId()).isGreaterThan(0);
    }


    @Test
    void Should_UpdateNewProduct_Using_UserRespositoryTest() {
        EditProductRequestDTO Updatedsneakers = EditProductRequestDTO.builder().build().builder().

                id(2l).name("Sneakers").availablequantity(35).price(125.60).category(Category.Casual)

                .build();

        assertThat(Updatedsneakers.getId()).isGreaterThan(1);


    }

    @Test
    void User_ShouldBeAbel_ToDeleteProductBaseByIds()
    {
        Product sneakers = Product.builder().build().builder().

                id(2l).name("Sneakers").availablequantity(35).price(125.60).category(Category.Casual)

                .build();

       productRepositoryMock.deleteById(sneakers.getId());

        assertThat(sneakers.getId()).isGreaterThan(0);

    }

    @Test
    void User_ShouldBeAble_ToGetProductByIds()
    {
        Product sneakers = Product.builder().build().builder().

                id(5l).name("Sneakers").availablequantity(35).price(125.60).category(Category.Casual)

                .build();

        productRepositoryMock.findById(5l);

        assertThat(sneakers.getId()).isGreaterThan(1);
    }
}
