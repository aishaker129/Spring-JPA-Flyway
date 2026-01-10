package com.jpa_flyway.exceptions;

public class UniversityNotFoundException extends RuntimeException{
    public UniversityNotFoundException(String message){
        super(message);
    }
}
