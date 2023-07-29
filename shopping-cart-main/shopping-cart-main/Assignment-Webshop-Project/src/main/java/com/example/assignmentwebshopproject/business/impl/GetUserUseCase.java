package com.example.assignmentwebshopproject.business.impl;

import com.example.assignmentwebshopproject.configuration.exception.userNotFoundException;
import com.example.assignmentwebshopproject.dto.UserDTO;


import java.util.Optional;

public interface GetUserUseCase {
    Optional<UserDTO> getUser(Long Id) throws userNotFoundException;




}
