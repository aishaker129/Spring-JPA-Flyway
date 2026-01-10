package com.jpa_flyway.mapper;

import com.jpa_flyway.dto.request.StudentRequest;
import com.jpa_flyway.dto.request.StudentUpdateRequest;
import com.jpa_flyway.dto.response.StudentResponse;
import com.jpa_flyway.entity.Student;

public class StudentMapper {
    public static StudentResponse toDto(Student student){
        return StudentResponse.builder()
                .id(student.getId())
                .name(student.getName())
                .dept(student.getDept())
                .email(student.getEmail())
                .phoneNumber(student.getPhoneNumber())
                .age(student.getAge())
                .intake(student.getIntake())
                .section(student.getSection())
                .universityId(student.getUniversity().getId())
                .build();
    }

    public static Student toEntity(StudentRequest request){
        Student student = new Student();

        student.setName(request.getName());
        student.setDept(request.getDept());
        student.setEmail(request.getEmail());
        student.setPhoneNumber(request.getPhoneNumber());
        student.setAge(request.getAge());
        student.setIntake(request.getIntake());
        student.setSection(request.getSection());
        return student;
    }

    public static Student toEntity(StudentUpdateRequest request,Student student){

        student.setName(request.getName());
        student.setDept(request.getDept());
        student.setEmail(request.getEmail());
        student.setPhoneNumber(request.getPhoneNumber());
        student.setAge(request.getAge());
        student.setIntake(request.getIntake());
        student.setSection(request.getSection());
        return student;
    }
}
