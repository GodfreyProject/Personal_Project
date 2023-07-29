package com.example.assignmentwebshopproject.dto;

import com.example.assignmentwebshopproject.persistence.entity.Order;
import com.example.assignmentwebshopproject.persistence.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PaymentByCardRequestDTO {


    //private Long id;


    private String address;

    private String zipcode;

    @NotBlank(message = "keep numbers and letters only")
   // @Pattern(regexp = "(/^([A-Z]{2})([0-9]{2})([A-Z0-9]{9,30})$/);")
    @Length(min = 12, max = 18)
    private String ibanCardno;



    private String date;


//    private Long orderId;

    private double  totalAmount;
    private Long userId;


}
