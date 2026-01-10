package com.jpa_flyway.controller;

import com.jpa_flyway.dto.request.StudentRequest;
import com.jpa_flyway.dto.request.StudentUpdateRequest;
import com.jpa_flyway.dto.response.ApiResponse;
import com.jpa_flyway.dto.response.StudentResponse;
import com.jpa_flyway.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentService studentService;

    @PostMapping("/enroll")
    public ResponseEntity<ApiResponse<StudentResponse>> enroleStudent(@Valid @RequestBody StudentRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createStudent(request));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<StudentResponse>>> getAllStudents(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentResponse>> getStudentById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentById(id));
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<ApiResponse<StudentResponse>> updateStudent(@PathVariable Long id,@Valid @RequestBody StudentUpdateRequest request){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.update(id,request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity< ApiResponse<Void>> deleteStudentById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.deleteStudentById(id));
    }
}
