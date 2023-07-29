package com.example.assignmentwebshopproject.business.impl;

import com.example.assignmentwebshopproject.dto.AccessTokenDTO;


public interface AccessTokenDecoder {
    AccessTokenDTO decode(String accessTokenEncoded);
}
