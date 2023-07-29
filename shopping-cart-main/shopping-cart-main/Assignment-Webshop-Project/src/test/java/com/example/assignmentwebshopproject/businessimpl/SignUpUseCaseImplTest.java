package com.example.assignmentwebshopproject.businessimpl;

import com.example.assignmentwebshopproject.business.SignUpUseCaseImpl;
import com.example.assignmentwebshopproject.config.exception.AlreadyExistsExceptionMessage;
import com.example.assignmentwebshopproject.config.exception.ExceptionMessages;
import com.example.assignmentwebshopproject.configuration.exception.ExceptionMessage;
import com.example.assignmentwebshopproject.dto.SignUpRequestDTO;
import com.example.assignmentwebshopproject.dto.SignUpResponseDTO;
import com.example.assignmentwebshopproject.persistence.UserRepository;

import com.example.assignmentwebshopproject.persistence.entity.User;
import org.apache.el.parser.AstNotEqual;
import org.hamcrest.core.IsNull;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.verification.VerificationMode;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class SignUpUseCaseImplTest {
    @Mock
    private UserRepository userRepositoryMock;
    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private SignUpUseCaseImpl signUpUseCase;

    @Test
    void signUp_shouldThrowException_whenEmailExists() {
        when(userRepositoryMock.existsByEmail("user@fontys.nl")).thenReturn(true);

        SignUpRequestDTO request = SignUpRequestDTO.builder()
                .email("user@fontys.nl")
                .build();

        AlreadyExistsExceptionMessage exceptionThrown = assertThrows(AlreadyExistsExceptionMessage.class, () -> {
            signUpUseCase.signUp(request);
        });
        assertEquals("400 BAD_REQUEST \"ALREADY_EXISTS_INFORMATION\"", exceptionThrown.getMessage());

        verify(userRepositoryMock).existsByEmail("user@fontys.nl");
    }

    @Test
    void signUp_shouldThrowException_whenUsernameExists() {
        when(userRepositoryMock.existsByEmail("user@fontys.nl")).thenReturn(false);
        when(userRepositoryMock.existsByUsername("username")).thenReturn(true);

        SignUpRequestDTO request = SignUpRequestDTO.builder()
                .email("user@fontys.nl")
                .username("username")
                .build();

        AlreadyExistsExceptionMessage exceptionThrown = assertThrows(AlreadyExistsExceptionMessage.class, () -> {
            signUpUseCase.signUp(request);
        });
        assertEquals("400 BAD_REQUEST \"ALREADY_EXISTS_INFORMATION\"", exceptionThrown.getMessage());
        verify(userRepositoryMock).existsByEmail("user@fontys.nl");
        verify(userRepositoryMock).existsByUsername("username");
    }

    @Test
    void signUpUser_shouldThrowException_whenUserFirstNameAlreadyExists() {

        when(userRepositoryMock.existsByFirstname("Daniel")).thenReturn(true);


        SignUpRequestDTO request = SignUpRequestDTO.builder()
                .email("user@fontys.nl")
                .username("username")
                .firstname("Daniel")
                .build();


        AlreadyExistsExceptionMessage exceptionThrown = assertThrows(AlreadyExistsExceptionMessage.class, () -> {
            signUpUseCase.signUp(request);
        });

        assertEquals("400 BAD_REQUEST \"ALREADY_EXISTS_INFORMATION\"", exceptionThrown.getMessage());

        verify(userRepositoryMock).existsByFirstname("Daniel");
    }


    @Test
    void signUpUser_shouldThrowException_whenUserLastNameAlreadyExists() {

        when(userRepositoryMock.existsByLastname("Anderson")).thenReturn(true);


        SignUpRequestDTO request = SignUpRequestDTO.builder()
                .email("user@fontys.nl")
                .username("username")
                .firstname("Daniel")
                .lastname("Anderson")
                .build();


        AlreadyExistsExceptionMessage exceptionThrown = assertThrows(AlreadyExistsExceptionMessage.class, () -> {
            signUpUseCase.signUp(request);
        });

        assertEquals("400 BAD_REQUEST \"ALREADY_EXISTS_INFORMATION\"", exceptionThrown.getMessage());

        verify(userRepositoryMock).existsByLastname("Anderson");
    }

    @Test
    void signUpUser_shouldThrowException_whenPasswordDoesNotMatch(){

        User findUser = userRepositoryMock.getUserByPassword("Anderson123");

        SignUpRequestDTO request = SignUpRequestDTO.builder()

                .password("Anderson123")
                .confirmPassword("BOOKED1")
                .build();
      // when(!passwordEncoder.matches(request.getPassword(),findUser.getPassword()));

        ExceptionMessage exceptionThrown = assertThrows(ExceptionMessage.class, () -> {
            signUpUseCase.signUp(request);
        });

        assertEquals("400 BAD_REQUEST \"PASSWORD_AND_CONFIRM_PASSWORD_DONT_MATCH\"", exceptionThrown.getMessage());


    }

    @Test
    void SignUp_ShoudCreateNewUser_whenUserCredential_201_AreValid()
    {


        User request = User.builder()
                .id(1L)
                .email("user@fontys.nl")
                .username("username")
                .firstname("Daniel")
                .lastname("Anderson")
                .password("BOOKED23")


                .build();
        SignUpResponseDTO responseDTO = SignUpResponseDTO.builder()
                .userId(1L)
                .build();


        userRepositoryMock.save(request);
        assertThat(request.getId()).isEqualTo(1);

    }



}



//    @Test
//    void isCustomerPresent() {
//
//    }





