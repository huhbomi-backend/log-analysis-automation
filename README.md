# 📊 Log Analysis & Reporting Automation

서비스 로그 데이터를 자동으로 정제·분석하여  
운영 지표(에러 현황, 트래픽, 서비스 요청 분포)를  
**엑셀 리포트 형태로 생성하는 배치형 데이터 파이프라인**입니다.

단순 로그 조회를 넘어,  
**운영 상태를 빠르게 파악할 수 있는 데이터 기반 리포트 자동화**를 목표로 구현했습니다.

---

## 🚀 프로젝트 핵심

> 로그 데이터를 단순 조회하는 수준이 아니라  
> **운영 지표로 변환하여 활용 가능한 정보로 만드는 것**에 집중했습니다.

- 로그 → 정제 → 분석 → 리포트 생성까지 전체 흐름 자동화
- 반복적인 로그 확인 업무 제거
- 서비스 운영 상태를 한눈에 파악 가능

---

## 🧠 해결하고자 한 문제

운영 환경에서는 로그가 지속적으로 쌓이지만,

- 로그 형식이 일정하지 않음
- 불필요한 데이터가 혼재
- 수작업으로 확인해야 하는 비효율

👉 로그는 존재하지만 **실질적인 분석 데이터로 활용되지 못하는 문제**가 존재했습니다.

---

## 💡 해결 방식

로그 데이터를 분석 가능한 형태로 변환하는  
**데이터 파이프라인 구조**를 설계했습니다.

```plaintext
[Log File]
   ↓
[Parsing]
   ↓
[Cleaning]
   ↓
[Analysis]
   ↓
[Excel Report]
```
---

## 패키지 구조
```
log_report_project/
│
├── main.py                # 전체 실행 흐름 제어 (Entry Point)
├── config.py              # 설정 관리
│
├── ingestion/             # 로그 수집 단계
│   └── log_reader.py      # 로그 파일 읽기
│
├── preprocess/            # 로그 정제 단계
│   ├── log_parser.py      # 문자열 → 구조화 데이터 변환
│   └── log_cleaner.py     # 노이즈 제거 및 정제
│
├── analysis/              # 데이터 분석 단계
│   ├── error_analysis.py      # 에러 분석
│   ├── traffic_analysis.py    # 시간대별 트래픽 분석
│   └── service_analysis.py    # 서비스별 요청 분석
│
├── report/                # 리포트 생성 단계
│   ├── excel_writer.py        # 엑셀 파일 생성
│   └── sheet_generator.py     # 시트 구성
│
├── utils/                 # 공통 유틸
│   ├── datetime_utils.py
│   └── file_utils.py
│
├── logs/                  # 원본 로그
│   └── sample.log
│
└── output/                # 결과 리포트
    └── report.xlsx
```
