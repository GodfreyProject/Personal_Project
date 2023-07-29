package com.example.assignmentwebshopproject.business.impl;


import com.example.assignmentwebshopproject.dto.EditUserRequestDTO;
import com.example.assignmentwebshopproject.persistence.entity.User;

public interface EditUserUseCase {
    void editUser(EditUserRequestDTO request);
}
