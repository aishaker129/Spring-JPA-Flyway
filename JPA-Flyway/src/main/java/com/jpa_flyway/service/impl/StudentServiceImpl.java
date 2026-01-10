package com.jpa_flyway.service.impl;

import com.jpa_flyway.dto.request.StudentRequest;
import com.jpa_flyway.dto.request.StudentUpdateRequest;
import com.jpa_flyway.dto.response.ApiResponse;
import com.jpa_flyway.dto.response.StudentResponse;
import com.jpa_flyway.entity.Student;
import com.jpa_flyway.entity.University;
import com.jpa_flyway.exceptions.StudentNotFoundExciption;
import com.jpa_flyway.exceptions.UniversityNotFoundException;
import com.jpa_flyway.mapper.StudentMapper;
import com.jpa_flyway.repository.StudentRepository;
import com.jpa_flyway.repository.UniversityRepository;
import com.jpa_flyway.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final UniversityRepository universityRepository;


    @Override
    public ApiResponse<StudentResponse> createStudent(StudentRequest request) {

        University university = universityRepository.findById(request.getUniversityId()).orElseThrow(
                ()-> new UniversityNotFoundException("University not found with id: "+request.getUniversityId())
        );

        Student student = StudentMapper.toEntity(request);
        student.setUniversity(university);
        studentRepository.save(student);

        StudentResponse response = StudentMapper.toDto(student);

        ApiResponse<StudentResponse> apiResponse = new ApiResponse<>(
                HttpStatus.CREATED.toString(),
                201,
                "Student created successfully",
                false,
                response
        );
        return apiResponse;
    }

    @Override
    public ApiResponse<List<StudentResponse>> getAll() {
        List<Student> students = studentRepository.findAll();
        List<StudentResponse> responses = new ArrayList<>();
        for(Student student:students){
            responses.add(StudentMapper.toDto(student));
        }

        ApiResponse<List<StudentResponse>> apiResponse = new ApiResponse<>(
                HttpStatus.OK.toString(),
                200,
                "Student list",
                false,
                responses
        );
        return apiResponse;
    }

    @Override
    public ApiResponse<StudentResponse> getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(
                ()-> new StudentNotFoundExciption("Student not found with id: "+id)
        );

        StudentResponse response = StudentMapper.toDto(student);

        return new ApiResponse<>(
                HttpStatus.OK.toString(),
                200,
                "Student found by id: "+id,
                false,
                response
        );
    }

    @Override
    public ApiResponse<StudentResponse> update(Long id, StudentUpdateRequest request) {
        Student student = studentRepository.findById(id).orElseThrow(
                ()-> new StudentNotFoundExciption("Student not found with id: "+id)
        );

        Student updateStudent = StudentMapper.toEntity(request,student);
        studentRepository.save(updateStudent);

        StudentResponse response = StudentMapper.toDto(updateStudent);
        ApiResponse<StudentResponse> apiResponse = new ApiResponse<>(
                HttpStatus.OK.toString(),
                200,
                "Student updated successfully",
                false,
                response
        );
        return apiResponse;
    }

    @Override
    public  ApiResponse<Void> deleteStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(
                ()-> new StudentNotFoundExciption("Student not found with id: "+id)
        );

        studentRepository.delete(student);
        ApiResponse<Void> apiResponse = new ApiResponse<>(
                HttpStatus.OK.toString(),
                200,
                "Student deleted successfully with id: "+id,
                false,
                null
        );
        return apiResponse;
    }
}
