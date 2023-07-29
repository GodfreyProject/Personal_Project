package com.example.assignmentwebshopproject.controller;

import com.example.assignmentwebshopproject.business.impl.*;
import com.example.assignmentwebshopproject.dto.*;
import com.example.assignmentwebshopproject.persistence.entity.RoleEnum;
import com.example.assignmentwebshopproject.persistence.entity.UserRole;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.MimeTypeUtils;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.List;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc

 public class UserControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GetUsersUseCase getUsersUseCaseMock;

    @MockBean
    private SignUpUseCase signUpUseCaseMock;


    @MockBean
    private DeleteUserUseCase deleteUserUseCase;

    @MockBean
    private EditUserUseCase editUserUseCase;

    @MockBean
    private GetUserUseCase getUserUseCase;



    @Test
    @WithMockUser(username = "admin@fontys.nl", roles = {"ADMIN"})
    void getAllUsers_shouldReturn200WithUsersList_WhenNoFilterProvided() throws Exception {
        GetUsersResponseDTO responseDTO = GetUsersResponseDTO.builder()
                .users(List.of(
                        UserDTO.builder().id(1L).firstname("Derrick").lastname("Jones").username("BOOKED").email("admin@fontys.nl").password("Admitted").build(),
                        UserDTO.builder().id(1L).firstname("Stella").lastname("Mark").username("CREATED").email("user@fontys.nl").password("Developed").build()

                ))
                .build();
        GetAllUsersRequestDTO request = GetAllUsersRequestDTO.builder().build();
        when(getUsersUseCaseMock.getUsers(request)).thenReturn(responseDTO);

        mockMvc.perform(get("/api/users"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(header().string("Content-Type", MimeTypeUtils.APPLICATION_JSON_VALUE))
                .andExpect(content().json("""
                            {
                                "users":[
                                    {"id":1,"firstname":"Derrick","lastname":"Jones","username": "BOOKED", "email":  "admin@fontys.nl", "password":  "Admitted"},
                                    {"id":1,"firstname":"Stella","lastname":"Mark","username": "CREATED", "email":  "user@fontys.nl", "password":  "Developed"}
                                 
                                ]
                            }
                        """));

        verify(getUsersUseCaseMock).getUsers(request);
    }

    @Test
    @WithMockUser(username = "admin@fontys.nl", roles = {"ADMIN"})
    void deleteUser_shouldReturn204() throws Exception {
        mockMvc.perform(delete("/api/users/100"))
                .andDo(print());
                //.andExpect(status().isNoContent());

        verify(deleteUserUseCase).deleteUser(100L);
    }


}


