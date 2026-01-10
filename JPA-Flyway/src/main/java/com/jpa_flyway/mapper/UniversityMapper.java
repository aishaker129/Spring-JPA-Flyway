package com.jpa_flyway.mapper;

import com.jpa_flyway.dto.request.UniversityRequest;
import com.jpa_flyway.dto.response.UniversityResponse;
import com.jpa_flyway.entity.University;
import org.springframework.stereotype.Component;


public class UniversityMapper {
    public static UniversityResponse toDto(University university){
        return UniversityResponse.builder()
                .id(university.getId())
                .name(university.getName())
                .location(university.getLocation())
                .build();
    }

    public static University toEntity(UniversityRequest request){
        University university = new University();

        university.setName(request.getName());
        university.setLocation(request.getLocation());
        return university;
    }
}
