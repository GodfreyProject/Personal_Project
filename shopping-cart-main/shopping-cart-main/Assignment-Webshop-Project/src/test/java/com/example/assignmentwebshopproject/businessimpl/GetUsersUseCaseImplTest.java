package com.example.assignmentwebshopproject.businessimpl;


import com.example.assignmentwebshopproject.business.GetUsersUseCaseImpl;
import com.example.assignmentwebshopproject.dto.GetAllUsersRequestDTO;
import com.example.assignmentwebshopproject.dto.GetUsersResponseDTO;
import com.example.assignmentwebshopproject.dto.UserDTO;
import com.example.assignmentwebshopproject.persistence.UserRepository;
import com.example.assignmentwebshopproject.persistence.entity.User;
import com.example.assignmentwebshopproject.persistence.entity.UserRole;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GetUsersUseCaseImplTest {

    @Mock
    private UserRepository userRepositoryMock;

    @InjectMocks
    private GetUsersUseCaseImpl getUsersUseCase;

    @Test
    void getUsersShouldReturnAllUsersResponseDTO() {
        User tom = User.builder().id(1l).firstname("Tom") .lastname("Cruise").email("tom.prune@gmail.com")
                .password("1234prune").username("Good")
                .build();

        User lucy = User.builder().id(2l).firstname("Lucy").lastname("George").email("lucy.luck@gmail.com")
                .password("1234luck").username("Booked")
               .build();

        when(userRepositoryMock.findAll()).thenReturn(List.of(tom, lucy));
        GetAllUsersRequestDTO request = GetAllUsersRequestDTO.builder().countryCode("Build").build();
        GetUsersResponseDTO actual = getUsersUseCase.getUsers( request);

        UserDTO tomDto = UserDTO.builder().id(1l).firstname("Tom").lastname("Cruise").email("tom.prune@gmail.com")
                .password("1234prune").username("Good")
                .build();

        UserDTO lucyDto = UserDTO.builder().id(2l).firstname("Lucy").lastname("George").email("lucy.luck@gmail.com")
                .password("1234luck").username("Booked")
                .build();

        GetUsersResponseDTO expected = GetUsersResponseDTO.builder().users(List.of(tomDto, lucyDto)).build();

        assertNotEquals(expected, actual);

        verify(userRepositoryMock).findAll();
    }
}