package com.jpa_flyway.service.impl;

import com.jpa_flyway.dto.request.UniversityRequest;
import com.jpa_flyway.dto.response.ApiResponse;
import com.jpa_flyway.dto.response.UniversityResponse;
import com.jpa_flyway.entity.University;
import com.jpa_flyway.mapper.UniversityMapper;
import com.jpa_flyway.repository.UniversityRepository;
import com.jpa_flyway.service.UniversityService;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UniversityServiceImpl implements UniversityService {
    private final UniversityRepository universityRepository;

    @Override
    public ApiResponse<UniversityResponse> createUniversity(UniversityRequest request) {
        University university = universityRepository.findByName(request.getName());

        if(university != null){
            throw new EntityExistsException("University name already exixts with name: "+request.getName());
        }

        University university1 = UniversityMapper.toEntity(request);
        universityRepository.save(university1);

        UniversityResponse response = UniversityMapper.toDto(university1);

        ApiResponse apiResponse = new ApiResponse(
                HttpStatus.CREATED.toString(),
                201,
                "University Created successfully",
                false,
                response
        );


        return apiResponse;
    }
}
