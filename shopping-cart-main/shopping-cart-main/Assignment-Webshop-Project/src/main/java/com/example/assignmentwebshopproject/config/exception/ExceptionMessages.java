package com.example.assignmentwebshopproject.config.exception;

import org.junit.jupiter.api.function;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class ExceptionMessages extends ResponseStatusException implements function {

    public ExceptionMessages(String errorcode){ super(HttpStatus.BAD_REQUEST, errorcode);}
    }


