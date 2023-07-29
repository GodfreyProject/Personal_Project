package com.example.assignmentwebshopproject.business;


import com.example.assignmentwebshopproject.business.impl.SignUpUseCase;
import com.example.assignmentwebshopproject.config.exception.AlreadyExistsExceptionMessage;
import com.example.assignmentwebshopproject.configuration.exception.ExceptionMessage;
import com.example.assignmentwebshopproject.dto.SignUpRequestDTO;
import com.example.assignmentwebshopproject.dto.SignUpResponseDTO;
import com.example.assignmentwebshopproject.persistence.UserRepository;
import com.example.assignmentwebshopproject.persistence.entity.RoleEnum;
import com.example.assignmentwebshopproject.persistence.entity.User;
import com.example.assignmentwebshopproject.persistence.entity.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SignUpUseCaseImpl implements SignUpUseCase {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public SignUpResponseDTO signUp(SignUpRequestDTO request) {
        if(userRepository.existsByEmail(request.getEmail())){
            throw new AlreadyExistsExceptionMessage();
        }
        else if(userRepository.existsByUsername(request.getUsername()))
        {
            throw new  AlreadyExistsExceptionMessage();
        }
        else if(userRepository.existsByFirstname(request.getFirstname()))
        {
            throw new  AlreadyExistsExceptionMessage();
        }
        else if(userRepository.existsByLastname(request.getLastname()))
        {
            throw new  AlreadyExistsExceptionMessage();
        }

        if(!request.getPassword().equals(request.getConfirmPassword())){
            throw new ExceptionMessage();
        }
        User savedUser = saveNewUser(request);

        return SignUpResponseDTO.builder()
                .userId(savedUser.getId())
                .build();


    }


    private User saveNewUser(SignUpRequestDTO request) {
        String encodedPassword = passwordEncoder.encode(request.getPassword());


        // countryEntity.
        User newUser = User.builder()

        .email(request.getEmail()).firstname(request.getFirstname()).lastname(request.getLastname())
                .username(request.getUsername()) .password(encodedPassword)
                .build();
        newUser.setUserRoles(Set.of(UserRole.builder().user(newUser).name(RoleEnum.CUSTOMER).build()));
        return userRepository.save(newUser);
    }

}
