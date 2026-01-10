package com.jpa_flyway.service;

import com.jpa_flyway.dto.request.StudentRequest;
import com.jpa_flyway.dto.request.StudentUpdateRequest;
import com.jpa_flyway.dto.response.ApiResponse;
import com.jpa_flyway.dto.response.StudentResponse;
import jakarta.validation.Valid;

import java.util.List;

public interface StudentService {

    ApiResponse<StudentResponse> createStudent( StudentRequest request);

    ApiResponse<List<StudentResponse>> getAll();

    ApiResponse<StudentResponse> getStudentById(Long id);

    ApiResponse<StudentResponse> update(Long id, StudentUpdateRequest request);

    ApiResponse<Void> deleteStudentById(Long id);
}
