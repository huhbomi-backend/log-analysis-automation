from datetime import datetime

def parse_log_line(line: str) -> dict:
    parts = [part.strip() for part in line.split("|")]

    if len(parts) != 6 :
        raise ValueError(f"로그 형식이 올바르지 않습니다: {line}")
    
    timestamp_str, service, level, request_info, status_str, response_time_str = parts
    
    request_parts = request_info.split(" ", maxsplit=1)
    if len(request_parts) != 2 :
        raise ValueError(f"로그 형식이 올바르지 않습니다: {line}")
    
    # http method : GET,POST,PUT,DELETE
    # endpoint : api
    method, endpoint = request_parts

    parsed_log = {
    "timestamp": datetime.strptime(timestamp_str, "%Y-%m-%d %H:%M:%S"),
    "service": service,
    "level": level,
    "method": method,
    "endpoint": endpoint,
    "status": int(status_str),
    "response_time_ms": int(response_time_str.replace("ms", "")),
    }

    return parsed_log

