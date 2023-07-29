package com.example.assignmentwebshopproject.dto;

import com.example.assignmentwebshopproject.persistence.entity.RoleEnum;
import com.example.assignmentwebshopproject.persistence.entity.ShoppingCart;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String email;
    private String firstname;
    private String lastname;
    private String username;

    private String password;


    private UserRoleDTO role;



}
