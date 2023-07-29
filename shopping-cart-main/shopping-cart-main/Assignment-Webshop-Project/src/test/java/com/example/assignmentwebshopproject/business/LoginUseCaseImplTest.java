package com.example.assignmentwebshopproject.business;

import com.example.assignmentwebshopproject.config.exception.InvalidCredentialsException;
import com.example.assignmentwebshopproject.config.exception.ProductAlreadyExistsException;
import com.example.assignmentwebshopproject.dto.LoginRequestDTO;
import com.example.assignmentwebshopproject.dto.SignUpRequestDTO;
import com.example.assignmentwebshopproject.persistence.ProductRepository;
import com.example.assignmentwebshopproject.persistence.UserRepository;
import com.example.assignmentwebshopproject.persistence.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LoginUseCaseImplTest {

    @Mock
    private UserRepository userRepositoryMock;


    @InjectMocks
    private LoginUseCaseImpl loginUseCaseMock;

    @Mock
    private PasswordEncoder passwordEncoder;


    @Test
    void Logincredentials_shouldThrowException_whenUsersEmailDoesNotExists() {

        when(userRepositoryMock.findByEmail("Sandra@fontys.nl")).thenReturn(null);


        LoginRequestDTO loginRequestDTO = LoginRequestDTO.builder()
                .email("Sandra@fontys.nl")
                .password("BOOKED123")
                .build();


        InvalidCredentialsException exceptionThrown = assertThrows(InvalidCredentialsException.class, () -> {
            loginUseCaseMock.login(loginRequestDTO);
        });


        assertEquals("400 BAD_REQUEST \"INVALID_CREDENTIALS\"", exceptionThrown.getMessage());
        verify(userRepositoryMock).findByEmail("Sandra@fontys.nl");
    }


    @Test
    void Logincredentials_shouldThrowException_whenUsersPasswordDoesNotExists() {


        User user = userRepositoryMock.getUserByPassword("BOOKED123@gmail.com");

        LoginRequestDTO request = LoginRequestDTO.builder()
                .email("Sandra@fontys.nl")
                .password("BOOKED123")


                .build();


        InvalidCredentialsException exceptionThrown = assertThrows(InvalidCredentialsException.class, () -> {
            loginUseCaseMock.login(request);
        });


        assertEquals("400 BAD_REQUEST \"INVALID_CREDENTIALS\"", exceptionThrown.getMessage());

    }

}
