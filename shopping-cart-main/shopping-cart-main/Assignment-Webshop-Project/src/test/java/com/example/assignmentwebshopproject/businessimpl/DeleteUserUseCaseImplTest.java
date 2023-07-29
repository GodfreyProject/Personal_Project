package com.example.assignmentwebshopproject.businessimpl;

import com.example.assignmentwebshopproject.business.DeleteUserUseCaseImpl;
import com.example.assignmentwebshopproject.persistence.UserRepository;

import com.example.assignmentwebshopproject.persistence.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
class DeleteUserUseCaseImplTest {

    @Mock
    private UserRepository userRepositoryMock;

    @InjectMocks
    private DeleteUserUseCaseImpl deleteUserUseCase;

    @Test
    void delete_ShouldDeleteUser_ByTheirUserIDs() {
        User tommy = User.builder().id(1L).firstname("Tommy").lastname("Prune").email("tommy.prune@gmail.com")
                .password("1234prune")
                .id(10l)
                .build();



        userRepositoryMock.deleteById(10l);


    }
}