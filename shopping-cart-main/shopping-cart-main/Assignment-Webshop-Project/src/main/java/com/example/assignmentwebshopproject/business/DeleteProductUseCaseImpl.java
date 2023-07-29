package com.example.assignmentwebshopproject.business;

import com.example.assignmentwebshopproject.business.impl.DeleteProductUseCase;

import com.example.assignmentwebshopproject.configuration.exception.ProductNotFoundWithThatIDException;
import com.example.assignmentwebshopproject.persistence.ProductRepository;
import com.example.assignmentwebshopproject.persistence.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeleteProductUseCaseImpl implements DeleteProductUseCase {
    private final ProductRepository productRepository;


    @Override
    @Transactional
    public void deleteProduct(Long id) {
        Optional<Product> deleteProduct = productRepository.findById(id);

        if(!productRepository.existsById(id))
        {
            throw new ProductNotFoundWithThatIDException(id);
        }
        else if(productRepository.existsById(id))
        {
            productRepository.deleteById(deleteProduct.get().getId());

        }


    }
}
