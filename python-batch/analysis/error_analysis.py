# 상태코드 기준으로 에러 판단

def analyze_errors(logs: list[dict]) -> dict :
    total = len(logs)
    error_count = 0

    for log in logs : 
        if log["status"]>=400 : 
            error_count += 1

    return {
        "total_requests": total,
        "error_count": error_count,
        "error_rate": round(error_count / total * 100, 2) if total > 0 else 0
    }