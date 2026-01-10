package com.jpa_flyway.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "students")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student extends BaseEntity{

    @Column(name = "student_name",nullable = false)
    @NotBlank(message = "Name can't be null")
    private String name;

    @NotBlank(message = "Depart can't be null")
    @Column(name = "department",nullable = false)
    private String dept;

    @NotBlank(message = "Email can't be null or Invalid formate")
    @Email
    @Column(name = "email",nullable = false)
    private String email;

    @NotBlank(message = "Phone number can't be null")
    @Column(name = "phone_number",nullable = false)
    private String phoneNumber;

    @NotNull(message = "Age can't be null")
    @Column(name = "age",nullable = false)
    private Integer age;

    @NotNull(message = "Intake can't be null")
    @Column(name = "intake",nullable = false)
    private Integer intake;

    @NotNull(message = "Section can't be null")
    @Column(name = "section",nullable = false)
    private Integer section;

    @ManyToOne
    @JoinColumn(name = "university_id")
    @JsonBackReference
    private University university;
}
