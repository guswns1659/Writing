# 1. 개요 
Spring JDBC OneToOne 매핑에 대한 공부를 기록. 자료는 notion에 스프링 페이지에 기록

## 2. OneToOne 매핑하는 법 2가지 
### 2.1 직접 매핑하며 사용한다. 

### 2.2 @Embedded.Nullable 이용 
두 객체는 유지하되 foreign key를 가지는 객체(엔티디)에 그 속성에 @Embedded.Nullable을 붙인다. 

```java
public class User {

    @Id
    private Long id;
    private String email;

    @Embedded.Nullable
    private Github github;

    public User(String email, Github github) {
        this.email = email;
        this.github = github;
    }
```

