package com.example.assignmentwebshopproject.business.impl;

import com.example.assignmentwebshopproject.dto.GetAllUsersRequestDTO;
import com.example.assignmentwebshopproject.dto.GetShoppingCartsRequestDTO;
import com.example.assignmentwebshopproject.dto.GetShoppingCartsResponseDTO;
import com.example.assignmentwebshopproject.dto.GetUsersResponseDTO;


public interface GetShoppingCartsUseCase {
    GetShoppingCartsResponseDTO getCartItems(GetShoppingCartsRequestDTO requestDTO);
}
