from config import LOG_FILE_PATH
from ingestion.log_reader import read_logs
from preprocess.log_parser import parse_log_line
from preprocess.log_cleaner import clean_logs

from analysis.error_analysis import analyze_errors
from analysis.traffic_analysis import analyze_traffic
from analysis.service_analysis import analyze_service


def main():
    raw_logs = read_logs(LOG_FILE_PATH)

    parsed_logs = []
    for line in raw_logs:
        try:
            parsed_log = parse_log_line(line)
            parsed_logs.append(parsed_log)
        except ValueError as error:
            print(f"[파싱 실패] {error}")

    # 정제
    cleaned_logs = clean_logs(parsed_logs)

    # 분석
    error_stats = analyze_errors(cleaned_logs)
    traffic_stats = analyze_traffic(cleaned_logs)
    service_stats = analyze_service(cleaned_logs)

    print("\n=== 에러 분석 ===")
    print(error_stats)

    print("\n=== 시간대별 트래픽 ===")
    print(traffic_stats)

    print("\n=== 서비스별 요청 수 ===")
    print(service_stats)


if __name__ == "__main__":
    main()