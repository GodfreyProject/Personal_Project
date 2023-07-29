package com.example.assignmentwebshopproject.business.impl;

import com.example.assignmentwebshopproject.dto.GetAllOrdersRequestDTO;
import com.example.assignmentwebshopproject.dto.GetAllUsersRequestDTO;
import com.example.assignmentwebshopproject.dto.GetOrdersResponseDTO;
import com.example.assignmentwebshopproject.dto.GetUsersResponseDTO;


public interface GetAllOrdersUseCase {
    GetOrdersResponseDTO getOrders(GetAllOrdersRequestDTO requestDTO);
}
