package com.example.assignmentwebshopproject.controller;


import com.example.assignmentwebshopproject.business.EditProductUseCaseImpl;
import com.example.assignmentwebshopproject.business.impl.DeleteProductUseCase;
import com.example.assignmentwebshopproject.business.impl.GetAllProductsUseCase;
import com.example.assignmentwebshopproject.business.impl.GetProductUseCase;
import com.example.assignmentwebshopproject.business.impl.ProductUseCase;
import com.example.assignmentwebshopproject.configuration.exception.ProductNotFoundWithThatIDException;
import com.example.assignmentwebshopproject.dto.*;
import com.example.assignmentwebshopproject.persistence.entity.Product;
import com.example.assignmentwebshopproject.security.auth.isauthenticated.isAuthenticated;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
@CrossOrigin( origins = "http://localhost:3000")
@RequiredArgsConstructor

public class ProductController {

    private final ProductUseCase productUseCase;

    private  final GetAllProductsUseCase productsUseCase;

    private final GetProductUseCase getProductUseCase;

    private  final DeleteProductUseCase deleteProductUseCase;

    private final EditProductUseCaseImpl editProductUseCase;

    private final AccessTokenDTO accessTokenDTO;

   @isAuthenticated
    @RolesAllowed({"ROLE_ADMIN"})
    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct (
            @RequestBody @Valid ProductRequestDTO request)  {
        ProductResponseDTO response = productUseCase.CreateNewProduct(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @isAuthenticated
     @RolesAllowed({"ROLE_ADMIN", "ROLE_CUSTOMER", "ROLE_SALES_MANAGER"})
    @GetMapping

    public ResponseEntity<GetProductsResponseDTO> getProducts() {
        return ResponseEntity.ok(productsUseCase.getProducts());
    }

    @isAuthenticated
    @RolesAllowed({"ROLE_ADMIN", "ROLE_CUSTOMER", "ROLE_SALES_MANAGER"})
    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id) throws ProductNotFoundWithThatIDException {//@PathVariable(value = "id") final long id
        final Optional<ProductDTO> productOptional = getProductUseCase.getProduct(id);
        if (productOptional.isEmpty()) {
             ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(productOptional.get());
    }
    @isAuthenticated
    @RolesAllowed({"ROLE_ADMIN"})
    @PutMapping("/{productId}")
    public Product updateProduct(@RequestBody @Valid EditProductRequestDTO request, @PathVariable Long productId)throws  ProductNotFoundWithThatIDException{
//        User response = editUserUseCase.editUser(request,id);
//@PathVariable Long id)
//        return new ResponseEntity<>(editUserUseCase) ResponseEntity.ok().body(HttpStatus.CREATED);

        return editProductUseCase.EditProduct(request, productId);
    }
    @isAuthenticated
    @RolesAllowed({"ROLE_ADMIN"})
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id)throws ProductNotFoundWithThatIDException{
        deleteProductUseCase.deleteProduct(id);
        return ResponseEntity.ok().build();


    }
}
