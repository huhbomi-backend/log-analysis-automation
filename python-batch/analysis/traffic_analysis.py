# 시간대별 트래픽

from collections import defaultdict

def analyze_traffic(logs: list[dict]) -> dict :
    traffic = defaultdict(int)

    for log in logs : 
        hour = log["timestamp"].hour
        traffic[hour] += 1

    return dict(sorted(traffic.items()))