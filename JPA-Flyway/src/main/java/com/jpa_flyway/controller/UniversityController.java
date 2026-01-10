package com.jpa_flyway.controller;

import com.jpa_flyway.dto.request.UniversityRequest;
import com.jpa_flyway.dto.response.ApiResponse;
import com.jpa_flyway.dto.response.UniversityResponse;
import com.jpa_flyway.service.UniversityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/university")
public class UniversityController {
    private final UniversityService universityService;

    @PostMapping
    public ResponseEntity<ApiResponse<UniversityResponse>> createUniversity(@Valid @RequestBody UniversityRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(universityService.createUniversity(request));
    }
}
