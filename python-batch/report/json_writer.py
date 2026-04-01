import json
from pathlib import Path


def save_report_json(
    error_stats: dict,
    traffic_stats: dict,
    service_stats: dict,
    output_path: Path
) -> None:
    summary = {
        "totalRequests": error_stats["total_requests"],
        "errorCount": error_stats["error_count"],
        "errorRate": error_stats["error_rate"]
    }

    traffic_by_hour = [
        {"hour": hour, "count": count}
        for hour, count in traffic_stats.items()
    ]

    service_request_counts = [
        {"service": service, "count": count}
        for service, count in service_stats.items()
    ]

    result = {
        "summary": summary,
        "trafficByHour": traffic_by_hour,
        "serviceRequestCounts": service_request_counts
    }

    output_path.parent.mkdir(parents=True, exist_ok=True)

    with open(output_path, "w", encoding="utf-8") as file:
        json.dump(result, file, ensure_ascii=False, indent=2)