package com.example.assignmentwebshopproject.business;

import com.example.assignmentwebshopproject.dto.UserDTO;
import com.example.assignmentwebshopproject.dto.UserRoleDTO;
import com.example.assignmentwebshopproject.persistence.entity.User;

import java.util.HashSet;
import java.util.Set;

public final class OrderUserDTOConverter {
    private OrderUserDTOConverter() {
    }

    public static UserDTO convertUserToDTO(User user) {
        Set<UserRoleDTO> roles = new HashSet<>();
        return UserDTO.builder().id(user.getId())
                .username(user.getUsername())
                .firstname(user.getFirstname())
                .build();


    }

}