package com.example.backend.report.dto;

import lombok.Data;

@Data
public class ServiceRequestCountResponse {

    private String service;
    private int count;
}