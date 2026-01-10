package com.jpa_flyway.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "universities")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class University extends BaseEntity{
    @Column(name = "university_name",nullable = false)
    @NotBlank(message = "University name can't be null")
    private String name;

    @Column(name = "university_location",nullable = false)
    @NotBlank(message = "Location can't be null")
    private String location;

    @OneToMany(mappedBy = "university", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Student> students;
}
