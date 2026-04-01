#데이터 정제

def clean_logs(parsed_logs: list[dict]) -> list[dict]:
    cleaned = []

    for log in parsed_logs:
        # status가 없는 경우 제거
        if "status" not in log:
            continue

        # timestamp 없는 경우 제거
        if "timestamp" not in log:
            continue

        cleaned.append(log)

    return cleaned