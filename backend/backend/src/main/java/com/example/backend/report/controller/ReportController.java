package com.example.backend.report.controller;

import com.example.backend.report.dto.ReportResponse;
import com.example.backend.report.dto.ServiceRequestCountResponse;
import com.example.backend.report.dto.SummaryResponse;
import com.example.backend.report.dto.TrafficByHourResponse;
import com.example.backend.report.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/report")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping
    public ReportResponse getReport() {
        return reportService.getReport();
    }

    @GetMapping("/summary")
    public SummaryResponse getSummary() {
        return reportService.getSummary();
    }

    @GetMapping("/traffic")
    public List<TrafficByHourResponse> getTrafficByHour() {
        return reportService.getTrafficByHour();
    }

    @GetMapping("/services")
    public List<ServiceRequestCountResponse> getServiceRequestCounts() {
        return reportService.getServiceRequestCounts();
    }
}