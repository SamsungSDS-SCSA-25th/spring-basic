# spring-basic

## 회원-주문-할인 예제로 배우기
- ### 회원 도메인 설계
![member.png](img/member.png)

- ### 주문과 할인 도메인 설계
![order-whole.png](img/order-whole.png)
![order-class.png](img/order-class.png)
![order-object.png](img/order-object.png)

- ### AppConfig로 DI
![appconfig.png](img/appconfig.png)

- ### Spring Bean으로 DI (Refactor)
  - AppConfig.java 참고

- ### 싱글톤 컨테이너
  - "객체 인스턴스가 JVM에 하나만 존재하는 패턴"
  - why? 클라이언트가 요청 할 때마다, 새로운 인스턴스가 만들어지면 안됨.
    - 메모리 낭비
    - Garbage Collection 리소스 소요
  
  - java만으로 싱글톤 패턴을 구현하면, (아래 그림 참고) 코드가 많고 DIP 위반 (.getInstance) 
  ![SingletonPattern.png](img/SingletonPattern.png)
  - 따라서, 스프링 컨테이너를 사용하면 편함.
  - #### 싱글톤 패턴의 주의점!
    - 하나의 객체 인스턴스 공유 => "stateless" 유지해야 함!
      - 특정 클라이언트에 의존적인 필드가 있으면 안됨
      - 특정 클라이언트만 값을 변경할 수 있는 필드가 있으면 안됨
      - 가급적 읽기만 가능하게 설계
      