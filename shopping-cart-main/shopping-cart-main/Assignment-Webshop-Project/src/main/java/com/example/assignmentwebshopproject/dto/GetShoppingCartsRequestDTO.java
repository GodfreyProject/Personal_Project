package com.example.assignmentwebshopproject.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class GetShoppingCartsRequestDTO {
    private String cartname;
}
