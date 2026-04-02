package com.example.backend.report.dto;

import lombok.Data;

@Data
public class TrafficByHourResponse {

    private int hour;
    private int count;

}
