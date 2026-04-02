package com.example.backend.report.dto;

import lombok.Data;

import java.util.List;

@Data
public class ReportResponse {

    private SummaryResponse summary;
    private List<TrafficByHourResponse> trafficByHour;
    private List<ServiceRequestCountResponse> serviceRequestCounts;
}