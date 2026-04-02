package com.example.backend.common.exception;

public class ReportFileNotFoundException extends RuntimeException{
    public ReportFileNotFoundException(String message){
        super(message);
    }
}
