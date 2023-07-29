package com.example.assignmentwebshopproject.business;


import com.example.assignmentwebshopproject.business.impl.GetUserUseCase;
import com.example.assignmentwebshopproject.configuration.exception.userNotFoundException;
import com.example.assignmentwebshopproject.dto.AccessTokenDTO;
import com.example.assignmentwebshopproject.dto.UserDTO;
import com.example.assignmentwebshopproject.persistence.UserRepository;
import com.example.assignmentwebshopproject.persistence.entity.RoleEnum;
import com.example.assignmentwebshopproject.persistence.entity.User;
import com.example.assignmentwebshopproject.security.auth.UnauthorizedDataAccessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class GetUserUseCaseImpl implements GetUserUseCase {
    private final UserRepository userRepository;

    private final AccessTokenDTO requestAccessToken;

    @Override
    public Optional<UserDTO> getUser(Long Id) {

        Optional<User> userDTO = userRepository.findById(Id);


        {
            if (!requestAccessToken.hasRole(RoleEnum.ADMIN.name())) {
                if (requestAccessToken.getUserId() != Id) {
                    throw new UnauthorizedDataAccessException("STUDENT_ID_NOT_FROM_LOGGED_IN_USER");
                }

                // return userRepository.findById(Id).map(UserDTOConverter::convertUserToDTO);

            }
            return userRepository.findById(Id).map(UserDTOConverter::convertUserToDTO);
        }

    }

}



