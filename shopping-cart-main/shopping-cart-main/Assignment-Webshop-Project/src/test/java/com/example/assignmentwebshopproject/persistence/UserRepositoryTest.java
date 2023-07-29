package com.example.assignmentwebshopproject.persistence;

import com.example.assignmentwebshopproject.business.GetUsersUseCaseImpl;
import com.example.assignmentwebshopproject.dto.*;
import com.example.assignmentwebshopproject.persistence.entity.User;
import io.jsonwebtoken.lang.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.verification.VerificationMode;
import reactor.test.StepVerifier;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
@ExtendWith(MockitoExtension.class)
public class UserRepositoryTest {

    @Mock
    private UserRepository userRepositoryMock;

    @InjectMocks

    private GetUsersUseCaseImpl getUsersUseCase;


    @Test
    void Should_SaveNewUser_Using_UserRespositoryTest()
    {
        User tom = User.builder().id(1l).firstname("Tom").lastname("Cruise").email("tom.prune@gmail.com")
                .password("1234prune").username("Eindhoven")
                .build();

        userRepositoryMock.save(tom);

        assertThat(tom.getId()).isGreaterThan(0);

    }

    @Test
    void Users_ShouldBeAble_ToUpdateTheirInfomations()
    {
        User tom = User.builder().id(5l).firstname("Tom").lastname("Cruise").email("tom.prune@gmail.com")
                .password("1234prune").username("Eindhoven")
                .build();



        EditUserRequestDTO updates = EditUserRequestDTO.builder()
                .id(5l) .firstname("Tom").lastname("Cruise").email("tom.prune@gmail.com")
                .password("1234prune").username("Eindhoven")
                .build();

        assertThat(updates.getId()).isGreaterThan(1);

      
    }

    @Test
    void User_ShouldBeAbel_ToDeleteUserBaseByIds()
    {

        User tom = User.builder().id(5l).firstname("Tom").lastname("Cruise").email("tom.prune@gmail.com")
                .password("1234prune").username("Eindhoven")
                .build();

        userRepositoryMock.deleteById(5l);

        assertThat(tom.getId()).isGreaterThan(1);

    }

    @Test
    void User_ShouldBeAbel_GetUserByIds()
    {

        User tom = User.builder().id(5l).firstname("Tom").lastname("Cruise").email("tom.prune@gmail.com")
                .password("1234prune").username("Eindhoven")
                .build();

        userRepositoryMock.findById(tom.getId());

        assertThat(tom.getId()).isGreaterThan(0);

    }
}
