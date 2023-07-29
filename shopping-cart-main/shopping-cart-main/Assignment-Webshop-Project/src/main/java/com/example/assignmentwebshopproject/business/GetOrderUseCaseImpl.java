package com.example.assignmentwebshopproject.business;

import com.example.assignmentwebshopproject.business.impl.GetOrderUseCase;
import com.example.assignmentwebshopproject.configuration.exception.InvalidUserException;
import com.example.assignmentwebshopproject.dto.OrderDTO;
import com.example.assignmentwebshopproject.persistence.OrderRepository;
import com.example.assignmentwebshopproject.persistence.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GetOrderUseCaseImpl implements GetOrderUseCase {

    private final OrderRepository orderRepository;
    @Override
    public Optional<OrderDTO> getOrderDetail(Long orderId) {
        Optional<Order> order = this.orderRepository.findById(orderId);

        if(order.isEmpty()){
            throw  new InvalidUserException("THAT_ORDER_ID_DOES_NOT_EXISTS");
        }


        return orderRepository.findById(orderId).map(OrderDTOConverter::convertOrderToDTO);
        //return order.isPresent() ? order.get() : null;

    }

}
