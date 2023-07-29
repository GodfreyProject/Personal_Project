package com.example.assignmentwebshopproject.dto;

import com.example.assignmentwebshopproject.persistence.entity.ShoppingCart;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class PaymentByCashResponseDTO {

    private  Long payByCashId;


}
