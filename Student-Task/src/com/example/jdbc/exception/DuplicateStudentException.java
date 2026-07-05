package com.example.jdbc.exception;

public class DuplicateStudentException extends Exception {

    public DuplicateStudentException(String message) {
        super(message);
    }
}