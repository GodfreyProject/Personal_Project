package com.example.assignmentwebshopproject.business;


import com.example.assignmentwebshopproject.business.impl.GetShoppingCartsUseCase;
import com.example.assignmentwebshopproject.business.impl.GetUsersUseCase;
import com.example.assignmentwebshopproject.dto.*;
import com.example.assignmentwebshopproject.persistence.ShoppingCartRepository;
import com.example.assignmentwebshopproject.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetShoppingCartsUseCaseImpl implements GetShoppingCartsUseCase {
    private final ShoppingCartRepository shoppingCartRepository;

//    @Override
//    public GetUsersResponseDTO getUsers() {
//        return null;
//    }

    @Override
    public GetShoppingCartsResponseDTO getCartItems(GetShoppingCartsRequestDTO requestDTO) {


        List<ShoppingCartDTO> CartItems = shoppingCartRepository.findAll()
                .stream()
                .map(ShoppingCartDTOConverter::convertShoppingToDTO)
                .toList();

        return GetShoppingCartsResponseDTO.builder().cartItems(CartItems).build();
    }
}
