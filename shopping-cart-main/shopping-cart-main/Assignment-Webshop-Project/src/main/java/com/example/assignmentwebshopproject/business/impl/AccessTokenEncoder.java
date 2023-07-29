package com.example.assignmentwebshopproject.business.impl;

import com.example.assignmentwebshopproject.dto.AccessTokenDTO;


public interface AccessTokenEncoder {
    String encode(AccessTokenDTO accessToken);
}
