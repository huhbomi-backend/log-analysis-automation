package com.example.backend.report.service;

import com.example.backend.report.dto.ReportResponse;
import com.example.backend.report.dto.ServiceRequestCountResponse;
import com.example.backend.report.dto.SummaryResponse;
import com.example.backend.report.dto.TrafficByHourResponse;
import com.example.backend.report.infra.ReportFileReader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ReportService {

    private final ReportFileReader reportFileReader;
    private final ObjectMapper objectMapper;

    public ReportResponse getReport() {
        log.info("리포트 전체 조회 요청");

        String json = reportFileReader.readReportJson();

        try {
            return objectMapper.readValue(json, ReportResponse.class);
        } catch (JsonProcessingException e) {
            log.error("리포트 JSON 파싱 중 오류 발생", e);
            throw new RuntimeException("리포트 JSON 파싱 중 오류가 발생했습니다.", e);
        }
    }

    public SummaryResponse getSummary() {
        log.info("리포트 summary 조회 요청");
        return getReport().getSummary();
    }

    public List<TrafficByHourResponse> getTrafficByHour() {
        log.info("리포트 traffic 조회 요청");
        return getReport().getTrafficByHour();
    }

    public List<ServiceRequestCountResponse> getServiceRequestCounts() {
        log.info("리포트 services 조회 요청");
        return getReport().getServiceRequestCounts();
    }
}