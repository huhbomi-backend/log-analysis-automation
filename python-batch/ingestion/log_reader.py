from pathlib import Path

def read_logs(file_path: Path) -> list[str]:
    if not file_path.exists():
        raise FileNotFoundError(f"로그 파일을 찾을 수 없습니다: {file_path}")

    with open(file_path, "r", encoding="utf-8") as file:
        lines = [line.strip() for line in file if line.strip()]

    return lines