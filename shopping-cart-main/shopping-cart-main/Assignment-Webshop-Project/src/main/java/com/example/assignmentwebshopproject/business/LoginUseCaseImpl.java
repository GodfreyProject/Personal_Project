package com.example.assignmentwebshopproject.business;

import com.example.assignmentwebshopproject.business.impl.AccessTokenEncoder;
import com.example.assignmentwebshopproject.business.impl.LoginUseCase;
import com.example.assignmentwebshopproject.config.exception.InvalidCredentialsException;
import com.example.assignmentwebshopproject.dto.AccessTokenDTO;
import com.example.assignmentwebshopproject.dto.LoginRequestDTO;
import com.example.assignmentwebshopproject.dto.LoginResponseDTO;
import com.example.assignmentwebshopproject.persistence.UserRepository;
import com.example.assignmentwebshopproject.persistence.UserRoleRepository;
import com.example.assignmentwebshopproject.persistence.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginUseCaseImpl implements LoginUseCase {
    private final UserRepository userRepository;
    private final AccessTokenEncoder accessTokenEncoder;
    private final PasswordEncoder passwordEncoder;

    private final UserRoleRepository userRoleRepository;

    @Override
    public LoginResponseDTO login(LoginRequestDTO request) {


        User user = userRepository.findByEmail(request.getEmail());




        if (user == null) {
            throw new InvalidCredentialsException();
        }


        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException();
        }



          List<String>  roles = user.getUserRoles().stream().map(userRole -> userRole.getName().toString()).toList();
            Long userId = user != null ? user.getId() : null;
            roles = user.getUserRoles().stream().map(userRole -> userRole.getName().toString()).toList();

            String accessToken = accessTokenEncoder.encode(AccessTokenDTO.builder().subject(user.getEmail()).userId(userId)
                    .roles(roles).build());

            return LoginResponseDTO.builder().roles(roles).accessToken(accessToken).build();
        }


    }


















