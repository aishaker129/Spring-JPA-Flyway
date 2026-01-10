package com.jpa_flyway.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UniversityRequest {
    @NotBlank(message = "University name can't be null")
    private String name;


    @NotBlank(message = "Location can't be null")
    private String location;
}
