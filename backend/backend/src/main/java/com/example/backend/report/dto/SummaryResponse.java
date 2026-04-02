package com.example.backend.report.dto;

import lombok.Data;

@Data
public class SummaryResponse {
    private int totalRequests;
    private int errorCount;
    private double errorRate;
}
