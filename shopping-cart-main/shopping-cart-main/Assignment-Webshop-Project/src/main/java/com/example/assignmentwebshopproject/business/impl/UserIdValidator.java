package com.example.assignmentwebshopproject.business.impl;

import com.example.assignmentwebshopproject.configuration.exception.InvalidUserException;


public interface UserIdValidator {
    void validateId(Long countryId) throws InvalidUserException;
}
