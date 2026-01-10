package com.jpa_flyway.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentUpdateRequest {
    @Column(name = "student_name",nullable = false)
    @NotBlank(message = "Name can't be null")
    private String name;

    @NotBlank(message = "Depart can't be null")
    @Column(name = "department",nullable = false)
    private String dept;

    @NotBlank(message = "Email can't be null or Invalid formate")
    @Email
    @Column(name = "department",nullable = false)
    private String email;

    @NotBlank(message = "Phone number can't be null")
    String phoneNumber;

    @NotNull(message = "Age can't be null")
    private Integer age;

    @NotNull(message = "Intake can't be null")
    private Integer intake;

    @NotNull(message = "Section can't be null")
    private Integer section;
}
