package com.example.assignmentwebshopproject.business;


import com.example.assignmentwebshopproject.business.impl.GetAllOrdersUseCase;
import com.example.assignmentwebshopproject.business.impl.GetUsersUseCase;
import com.example.assignmentwebshopproject.dto.*;
import com.example.assignmentwebshopproject.persistence.OrderRepository;
import com.example.assignmentwebshopproject.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetOrdersUseCaseImpl implements GetAllOrdersUseCase {
    private final OrderRepository orderRepository;

//    @Override
//    public GetUsersResponseDTO getUsers() {
//        return null;
//    }

    @Override
    public GetOrdersResponseDTO getOrders(GetAllOrdersRequestDTO requestDTO) {


        List<OrderDTO> Orders = orderRepository.findAll()
                .stream()
                .map(OrderDTOConverter::convertOrderToDTO)
                .toList();

        return GetOrdersResponseDTO.builder().orders(Orders).build();
    }
}
