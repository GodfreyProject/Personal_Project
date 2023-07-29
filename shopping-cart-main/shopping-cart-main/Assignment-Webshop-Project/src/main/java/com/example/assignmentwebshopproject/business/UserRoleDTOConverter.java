package com.example.assignmentwebshopproject.business;

import com.example.assignmentwebshopproject.dto.UserRoleDTO;
import com.example.assignmentwebshopproject.persistence.entity.UserRole;

public final class UserRoleDTOConverter {
    UserRoleDTOConverter(){
    }

    public static UserRoleDTO convert(UserRole user){
                return  UserRoleDTO.builder()
                        .id(user.getId())
                        .name(user.getName())
                        //.user(user.getUser())
                .build();

    }
}
