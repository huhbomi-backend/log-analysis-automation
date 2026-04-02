package com.example.backend.report.infra;

import com.example.backend.common.exception.ReportFileNotFoundException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class ReportFileReader {

    private static final String REPORT_FILE_PATH = "../../python-batch/output/report.json";

    public String readReportJson() {
        try {
            Path path = Path.of(REPORT_FILE_PATH);

            if (!Files.exists(path)) {
                throw new ReportFileNotFoundException("리포트 파일을 찾을 수 없습니다: " + path.toAbsolutePath());
            }

            return Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException("리포트 파일을 읽는 중 오류가 발생했습니다.", e);
        }
    }
}