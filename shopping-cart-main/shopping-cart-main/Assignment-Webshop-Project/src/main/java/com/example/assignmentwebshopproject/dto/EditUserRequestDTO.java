package com.example.assignmentwebshopproject.dto;

import com.example.assignmentwebshopproject.persistence.entity.UserRole;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EditUserRequestDTO {
    private Long id;

    @NotBlank(message = "Email cannot be empty")
//    @Length(max = 50)
    private String email;

    @NotBlank
//    @Length(max = 50)
    private String firstname;

    @NotBlank
//    @Length(max = 50)
    private String lastname;

    @NotBlank
//    @Length(max = 50)
    private String username;



    @NotBlank
//    @Length(min = 8, max = 50)
    private String password;


    @Enumerated(EnumType.STRING)
    @Column(name="role")
    private UserRole role;
}
