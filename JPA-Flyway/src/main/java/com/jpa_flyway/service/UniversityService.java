package com.jpa_flyway.service;

import com.jpa_flyway.dto.request.UniversityRequest;
import com.jpa_flyway.dto.response.ApiResponse;
import com.jpa_flyway.dto.response.UniversityResponse;
import jakarta.validation.Valid;

public interface UniversityService {
    ApiResponse<UniversityResponse> createUniversity(@Valid UniversityRequest request);
}
