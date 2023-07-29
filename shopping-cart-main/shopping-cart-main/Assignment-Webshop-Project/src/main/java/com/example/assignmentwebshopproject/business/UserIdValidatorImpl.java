package com.example.assignmentwebshopproject.business;

import com.example.assignmentwebshopproject.business.impl.UserIdValidator;
import com.example.assignmentwebshopproject.configuration.exception.InvalidUserException;
import com.example.assignmentwebshopproject.persistence.UserRepository;
import com.example.assignmentwebshopproject.persistence.UserRoleRepository;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserIdValidatorImpl implements UserIdValidator {
    private final UserRepository userRepository;

    @Override
    public void validateId(Long userId) {
        if (userId == null || !userRepository.existsById(userId)) {
            throw new InvalidUserException("ALL_EXISTS");
        }
    }
}
