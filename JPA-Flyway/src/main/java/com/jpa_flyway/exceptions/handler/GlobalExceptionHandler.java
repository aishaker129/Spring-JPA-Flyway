package com.jpa_flyway.exceptions.handler;

import com.jpa_flyway.dto.response.ApiResponse;
import com.jpa_flyway.dto.response.StudentResponse;
import com.jpa_flyway.exceptions.StudentNotFoundExciption;
import com.jpa_flyway.exceptions.UniversityNotFoundException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

    @ExceptionHandler(UniversityNotFoundException.class)
    public ResponseEntity<ApiResponse<StudentResponse>> handleUniversityNotFoundException(UniversityNotFoundException e){

        ApiResponse<StudentResponse> response = new ApiResponse<>(
                HttpStatus.NOT_FOUND.toString(),
                404,
                e.getMessage(),
                true,
                null

        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiResponse<StudentResponse>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        Map<String,String> errors = new HashMap<>();
        for(FieldError fe: e.getBindingResult().getFieldErrors()){
            errors.put(fe.getField(),fe.getDefaultMessage());
        }


        ApiResponse<StudentResponse> apiResponse = new ApiResponse<>(
                HttpStatus.BAD_REQUEST.toString(),
                400,
                errors.values().toString(),
                true,
                null
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiResponse);
    }

    @ExceptionHandler(StudentNotFoundExciption.class)
    public ResponseEntity<ApiResponse<StudentResponse>> handleStudentNotFoundExciption(StudentNotFoundExciption e){

        ApiResponse<StudentResponse> response = new ApiResponse<>(
                HttpStatus.NOT_FOUND.toString(),
                404,
                e.getMessage(),
                true,
                null

        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
