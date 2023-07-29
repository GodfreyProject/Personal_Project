package com.example.assignmentwebshopproject.business;

import com.example.assignmentwebshopproject.dto.UserDTO;
import com.example.assignmentwebshopproject.dto.UserRoleDTO;
import com.example.assignmentwebshopproject.persistence.entity.RoleEnum;
import com.example.assignmentwebshopproject.persistence.entity.User;
import com.example.assignmentwebshopproject.persistence.entity.UserRole;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class UserDTOConverter {
    private UserDTOConverter() {
    }

    public static UserDTO convertUserToDTO(User user) {
        Set<UserRoleDTO> roles = new HashSet<>();
        return UserDTO.builder().id(user.getId()).email(user.getEmail()).firstname(user.getFirstname()).lastname(user.getLastname())
                .username(user.getUsername())
                .build();


    }

}