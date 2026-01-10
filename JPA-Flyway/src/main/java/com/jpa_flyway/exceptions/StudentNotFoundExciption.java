package com.jpa_flyway.exceptions;

public class StudentNotFoundExciption extends RuntimeException{
    public StudentNotFoundExciption(String message){
        super(message);
    }
}
