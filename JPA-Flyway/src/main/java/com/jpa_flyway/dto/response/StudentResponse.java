package com.jpa_flyway.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentResponse {
    private Long id;
    private String name;
    private String dept;
    private String email;
    private String phoneNumber;
    private Integer age;
    private Integer intake;
    private Integer section;
    private Long universityId;
}
