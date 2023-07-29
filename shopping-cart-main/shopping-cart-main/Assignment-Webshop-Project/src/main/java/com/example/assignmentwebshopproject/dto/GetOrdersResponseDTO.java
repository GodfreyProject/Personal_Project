package com.example.assignmentwebshopproject.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class GetOrdersResponseDTO {
    private List<OrderDTO> orders;
}
