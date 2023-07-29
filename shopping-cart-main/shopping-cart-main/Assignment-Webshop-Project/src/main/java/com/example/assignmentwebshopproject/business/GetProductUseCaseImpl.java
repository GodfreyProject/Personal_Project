package com.example.assignmentwebshopproject.business;


import com.example.assignmentwebshopproject.business.impl.GetProductUseCase;
import com.example.assignmentwebshopproject.configuration.exception.ProductNotFoundWithThatIDException;
import com.example.assignmentwebshopproject.configuration.exception.userNotFoundException;
import com.example.assignmentwebshopproject.dto.ProductDTO;
import com.example.assignmentwebshopproject.persistence.ProductRepository;
import com.example.assignmentwebshopproject.persistence.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GetProductUseCaseImpl implements GetProductUseCase {
    private final ProductRepository productRepository;
    //private final AccessTokenDTO requestAccessToken;

    @Override
    public Optional<ProductDTO> getProduct(Long id) throws userNotFoundException {


        Optional<Product> productDTO = productRepository.findById(id);



        if(!productRepository.existsById(id)) {

            throw new ProductNotFoundWithThatIDException(id);
//            return productRepository.findById(id).map(ProductDTOConverter::convertProductToDTO);

        }else{

            return productRepository.findById(id).map(ProductDTOConverter::convertProductToDTO);
//            throw new UserNotFoundWithIDException("Sorry, that Particular Product was not Found with that  Product- ID:" + id);

        }

    }


}
