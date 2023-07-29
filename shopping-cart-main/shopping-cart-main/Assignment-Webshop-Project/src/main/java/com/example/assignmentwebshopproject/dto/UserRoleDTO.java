package com.example.assignmentwebshopproject.dto;

import com.example.assignmentwebshopproject.persistence.entity.RoleEnum;
import com.example.assignmentwebshopproject.persistence.entity.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UserRoleDTO {


    private Long id;

    @NotNull

    @Enumerated(EnumType.STRING)
    private RoleEnum name;


    private User user;
}

