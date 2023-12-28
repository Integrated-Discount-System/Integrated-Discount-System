## ✏️ 통합 할인 시스템 (Integrated-Discount-System)

### 최대 할인 가격 안내

---

### 문제 정의

```
놀이공원, 영화관, 레스토랑 등에서 다양한 할인을 받을 수 있다.
하지만 매번 어떤 할인을 받을 수 있는지 직접 조사해야 하는 불편함을 느꼈음.
따라서 위의 불편함을 해소하고자 통합 할인 시스템(IDS)를 만들고자 함.
```

<img width="200" alt="image" src="https://github.com/Integrated-Discount-System/Integrated-Discount-System/assets/60764632/23038718-68f7-4388-879b-f3c34cd273f1">
<img width="260" alt="image" src="https://github.com/Integrated-Discount-System/Integrated-Discount-System/assets/60764632/e90e7c91-8807-42f7-819c-4f230ae063e0">
<img width="200" alt="image" src="https://github.com/Integrated-Discount-System/Integrated-Discount-System/assets/60764632/856286d1-5cf0-49eb-81d2-f97c870aa292">

---

### 👥 팀 이름 : IDS

#### 팀원 : 김태우, 강지훈, 임주현, 이재현, 양혜인

---

### 시퀀스 다이어그램

<img width="300" alt="image" src="https://github.com/Integrated-Discount-System/Integrated-Discount-System/assets/60764632/603e1cff-c4f3-4d54-b148-9777a6697529">


**안녕하세요. IDS 입니다. 기능을 선택해주세요.**

1. 이벤트 보기

```
1만원 이상 결제시 랜덤 상품 지급 (콜라: 2000, 츄러스: 3000, 젤라또: 4000)
네이버 / 카카오 페이 결제시 5% 포인트 페이백
홀수 달 멤버십 적립 (Silver : 1%, Gold: 3%, Vip: 5%)
짝수 달 멤버십 적립 (Silver : 5천원, Gold: 8천원, Vip: 1만원)
야간 할인 : 30% 할인
10~12월 수능 할인 : 20% 추가 할인
```

2. 할인 목록 출력
    - 카드 할인 (국민: 20%, 신한: 15%, 현대: 20%)
    - 통신 할인 (KT - 40%, SKT - 30%)
    - 군인, 노인(66세) (무료)
    - 수능 할인 (20%)
    - 페이 (카카오페이: 8%, 네이버페이:8%)
    - 야간 할인 (20%)
    - 단체 할인 - 10명이상 (25%)
3. 할인률 계산기
    - 총 금액
    - 할인 금액
    - 이벤트 할인 금액 or 증정 선물
    - 멤버십 혜택
    - 예상 결제 금액 (개인별 총 할인 금액 보여주기)
    - 멤버십 승급 가능 여부
4. 현재 멤버십 + 어떤 사은품 받을 수 있는지 보여주기 (Silver, Gold, Vip)

q. 종료

---

### Usecase Diagram

<img width="600" alt="image" src="https://github.com/Integrated-Discount-System/Integrated-Discount-System/assets/60764632/e8fc03fd-51ad-4589-b9d8-f0a420f780e4">

---

### 요구사항 정의

통합 할인 시스템 기능을 구현해야한다. 통합 할인 시스템은 아래와 같이 정의한다.

<img width="1400" alt="image" src="https://github.com/Integrated-Discount-System/Integrated-Discount-System/assets/60764632/a8710267-805c-419b-93af-a3bb2fa56b2b">

- 기본 요금은 아래와 같다.

```
	- 유아 (0, 1) - 10000원
	- 어린이 (2 ~ 12) - 30000원
	- 청소년 (13 ~ 18) - 40000원
	- 어른 (19 ~ 65) - 50000원
```

- 진행되는 이벤트는 시스템 관리자에 의해 유연하게 변경 가능하다.

- 최종 결제 금액의 1인 결제 금액이 1만원이 넘지 않는다면 모든 이벤트에 참여 불가능하다.

- 멤버십 등급은 계절 멤버십 (*문제 : 4/30 결제했지만 5/1에는 0원이 된다.*)

```
멤버십 등급	
	- 누적 포인트 1만원 이상 : Silver
	- 누적 포인트 3만원 이상 : Gold
	- 누적 포인트 5만원 이상 : Vip
멤버십 혜택
	- Silver - 1만원 상당의 선물 증정(인형)
	- Gold - 2만원 상당의 선물 증정(텀블러)
	- Vip - 3만원 상당의 선물 증정(치킨 쿠폰)
```

- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[Exception]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.

---

### 입출력 요구사항

#### 입력

- 사용할 기능을 입력한다.

```
1. 이벤트 보기
2. 할인 목록 보기
3. 할인률 계산기
4. 현재 멤버십 보기
q. 종료
```

- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[Exception]"로 시작해야 한다.

```
[Exception] 입력값이 올바르지 않습니다. 다시 입력해주세요.
```

- 엑셀 데이터 읽기

```
이름
age
국민카드 
신한카드 
kt
skt 
army 
collegeTest
네이버페이
카카오페이
분기
누적 금액
```

#### 출력

- 할인률 계산 결과는 다음과 같이 출력한다.

```
<총 금액>
100,000원

<할인 금액>
국민카드 할인 : 20,000원

<이벤트 할인 금액>
네이버 페이 적립 : 5,000원
(이벤트) 야간 할인 : 5,0000원

<멤버십 혜택>
선물 증정 : 텀블러

<예상 결제 금액>
60,000원

<멤버십 승급 가능 여부>
철수 : Gold 승급 가능
```

- 엑셀 데이터 쓰기

```
첫 결제 날짜 쓰기
    - 분기가 지나면 누적 금액을 0으로 초기화
    - 1분기: 1~3월
    - 2분기: 4~6월
    - 3분기: 7~9월
    - 4분기: 10~12월
결제 누적 금액 쓰기
```

- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[WRITE_ERROR]"로 시작해야 한다.

```
[WRITE_ERROR] 유효한 엑셀 쓰기 값이 아닙니다. 다시 시도해주세요.
```



