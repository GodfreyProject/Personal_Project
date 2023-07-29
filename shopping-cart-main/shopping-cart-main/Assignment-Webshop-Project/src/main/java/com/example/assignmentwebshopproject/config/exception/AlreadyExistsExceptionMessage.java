package com.example.assignmentwebshopproject.config.exception;

import org.junit.jupiter.api.function;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class AlreadyExistsExceptionMessage extends ResponseStatusException {

       public AlreadyExistsExceptionMessage(){ super(HttpStatus.BAD_REQUEST, "ALREADY_EXISTS_INFORMATION");}
    }


