# 서비스별 요청수

from collections import defaultdict

def analyze_service(logs: list[dict]) -> dict:
    service_count = defaultdict(int)

    for log in logs:
        service = log["service"]
        service_count[service] += 1

    return dict(service_count)