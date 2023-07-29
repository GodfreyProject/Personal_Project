package com.example.assignmentwebshopproject.configuration.exception;

public class userNotFoundException extends RuntimeException{

    public userNotFoundException(Long id){
        super("User with that particular User-Id does not Exist :" + id);
    }
}
