package com.example.assignmentwebshopproject.business;


import com.example.assignmentwebshopproject.business.impl.GetUsersUseCase;
import com.example.assignmentwebshopproject.dto.GetAllUsersRequestDTO;
import com.example.assignmentwebshopproject.dto.GetUsersResponseDTO;
import com.example.assignmentwebshopproject.dto.UserDTO;
import com.example.assignmentwebshopproject.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetUsersUseCaseImpl implements GetUsersUseCase {
    private final UserRepository userRepository;

//    @Override
//    public GetUsersResponseDTO getUsers() {
//        return null;
//    }

    @Override
    public GetUsersResponseDTO getUsers(GetAllUsersRequestDTO requestDTO) {


        List<UserDTO> users = userRepository.findAll()
                .stream()
                .map(UserDTOConverter::convertUserToDTO)
                .toList();

        return GetUsersResponseDTO.builder().users(users).build();
    }
}
