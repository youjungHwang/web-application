## 웹 애플리케이션 구조 이해

### 계산기 서블릿 만들기
간단한 사칙연산을 웹 애플리케이션으로 제공하는 서버입니다. 사용자는 HTTP 요청을 통해 두 숫자와 연산자를 전달하면 서버에서 계산 결과를 반환합니다.
```
calculator
├── WebApplicationServerLauncher.java  // 내장 Tomcat 서버 실행
├── operator
│   ├── AdditionOperator.java          // 덧셈 연산자
│   ├── ArithmeticOperator.java        // 연산자 인터페이스
│   ├── DivisionOperator.java          // 나눗셈 연산자
│   ├── MultiplicationOperator.java    // 곱셈 연산자
│   └── SubtractionOperator.java       // 뺄셈 연산자
├── domain
│   ├── Calculator.java                // 사칙연산 로직 처리
│   └── PositiveNumber.java            // 양수 입력 검증
└── CalculatorServlet.java             // HTTP 요청 처리
```
---
### 의존성 주입(DI)을 구현하는 간단한 BeanFactory 예제
Controller, Service, Inject와 같은 커스텀 애너테이션을 사용하여 객체 간의 의존성을 관리하고 주입하는 방식으로 동작합니다.
