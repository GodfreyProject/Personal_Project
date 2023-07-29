package com.example.assignmentwebshopproject.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class GetShoppingCartsResponseDTO {
    private List<ShoppingCartDTO> cartItems;
}
