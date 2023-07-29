package com.example.assignmentwebshopproject.businessimpl;


import com.example.assignmentwebshopproject.business.UserDTOConverter;
import com.example.assignmentwebshopproject.dto.UserDTO;
import com.example.assignmentwebshopproject.persistence.entity.User;
import com.example.assignmentwebshopproject.persistence.entity.UserRole;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class UserDTOConverterTest {

    @Test
    void shouldConverUserToDTO() {
        User tom = User.builder().id(1l).firstname("Tom").lastname("Cruise").email("tom.prune@gmail.com")
                .password("1234prune").username("Eindhoven")
               .build();

        UserDTO actual = UserDTOConverter.convertUserToDTO(tom);

        UserDTO expected = UserDTO.builder().id(1l).firstname("Tom").lastname("Cruise").email("tom.prune@gmail.com")
                .password("1234prune").username("Eindhoven")
               .build();

        assertNotEquals(expected, actual);
    }


}