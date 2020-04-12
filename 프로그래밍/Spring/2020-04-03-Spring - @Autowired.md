[참고강의 : 백기선의 스프링 핵심기술](https://www.inflearn.com/course/spring-framework_core/dashboard)

## 1. 개요
스프링의 마법같은 @Autowired 어노테이션에 대해 공부하고 정리한 글입니다. @Autowired는 인스턴스를 생성하지 않아도 스프링이 자동으로 인스턴스를 주입해주는 기능입니다.  

### 1.1 의존성이란
[의존성이란 무엇인가? 참고](https://github.com/guswns1659/Writing/blob/3e4025dfcfc7c60d75f6b31f578baa7700ba6451/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D/Spring/2020-04-12-Spring%20-%20%EC%9D%98%EC%A1%B4%EC%84%B1%EC%9D%B4%EB%9E%80%20%EB%AC%B4%EC%97%87%EC%9D%B8%EA%B0%80.md)

## 2. 의존성 주입 방법 3가지
###  2.1 @Autowired 사용 
아래 코드처럼 빈으로 등록된 객체를 주입하고 싶을 때 @Autowired를 붙인다. 

```java
public class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;
}

```

###  2.2 생성자
@Autowired를 사용하지 않고 생성자를 통해서도 의존성 주입을 할 수 있다.
> As of Spring Framework 4.3, an @Autowired annotation on such a constructor is no longer necessary if the target bean defines only one constructor to begin with. However, if several constructors are available, at least one must be annotated with @Autowired in order to instruct the container which one to use. 

공식문서에서는 생성자가 하나일 경우 @Autowired는 필수는 아니지만 2개 이상일 경우 붙여줘야 한다. 

```java
public class UserRepositoryTest {
    private UserRepository userRepository;

    @Autowired
    public UserRepositoryTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
```

###  2.3 setter
setter를 이용해서 의존성 주입을 할 수있다. 

```java
public class UserRepositoryTest {
    private UserRepository userRepository;
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;    
    }
}
```

## 3. 같은 타입 빈이 여러개일 때
만약 같은 타입의 빈이 여러개일 때 스프링은 어떻게 의존성을 주입해줄까? 아래처럼 Repository를 상속받는 Repository가 2개라고 생각해보자. BookService에서 주입해야 하는 상황 

```java
@Repository
public class HyunjunRepository implements BookRepository {
}

@Repository
public class MyBookRepository implements BookRepository {
}

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
}
```

위 상태에서 주입하려고 하면 '빈이 2개라서 어떤 빈을 주입할 지 모르겠다'는 에러가 뜬다. 그리고 친절하게 해결책을 알려준다.  

```java
Description:

Field bookRepository in com.spring.springcore.BookService required a single bean, but 2 were found:

Action : 
Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans, or using @Qualifier to identify the bean that should be consumed

```
### 3.1 @primary
@Primary를 사용하면 스프링에서 우선적으로 의존성 주입을 해준다. 

```java
@Repository @Primary
public class HyunjunRepository implements BookRepository {
}
```

#### 3.1.1 ApplicationRunner로 의존성 확인
그럼 실제로 @Primary 빈이 주입됐는지 ApplicationRunner로 살펴보자. ApplicationRunner는 앱이 구동된 다음 실행된다. 

```java
@Component
public class BookServiceRunner implements ApplicationRunner {

    @Autowired
    BookService bookService;

    @Override
    public void run(ApplicationArguments args) {
        bookService.printBookRepository();
    }
}
```

콘솔에서 살펴보면 아래처럼 @Primary가 동작하는 걸 확인할 수 있다. 

```java
class com.spring.springcore.HyunjunRepository
```

### 3.2 @Qualified
@Qualified는 의존성 주입이 필요한 BookService에 붙인다. 주의할 점은 주입되는 빈의 앞글자는 소문자이다. @Primary가 더 타입에 safe하기 때문에 이 방법은 추천되지 않는다. 

```java
@Service
public class BookService {

    @Autowired @Qualifier("hyunjunRepository")
    private BookRepository bookRepository;

    public void printBookRepository() {
        System.out.println(bookRepository.getClass());
    }
}
```
### 3.3 전부 주입
해당하는 타입의 빈을 모두 주입하는 방법이다. 주입이 필요한 BookService에서 필드 타입을 List<>로 선언한다. 

```java
@Service
public class BookService {

    @Autowired
    private List<BookRepository> bookRepositories;

    public void printBookRepository() {
        this.bookRepositories.forEach(System.out::println);
    }
}
```

### 3.4 타입이 아닌 필드명으로 주입
사실 스프링은 의존성 주입할 때 타입뿐만 아니라 빈의 이름도 비교한다. 그래서 필드명을 맞춰주면 의존성 주입을 받을 수 있다. 아래 코드를 보면 직접 myBookRepository라는 빈의 이름을 적어주니 스프링이 의존성 주입을 해준다. 다만, **앞글자는 소문자로** 

```java
@Service
public class BookService {

    @Autowired
    private BookRepository myBookRepository;

    public void printBookRepository() {
        System.out.println(myBookRepository.getClass());
    }
}
```

## 4. AutowiredAnnotationBeanPostProcessor
그럼 어떻게 스프링 내부에 @Autowired가 동작할까? 너무 깊게 알 필요는 없지만 AutowiredAnnotationBeanPostProcessor라는 프로세스를 통해서 의존성이 주입된다. 라이프 사이클 콜백의 일종으로 스프링 앱이 초기화될 때 동작하는 프로세스라고 생각하면 될거 같다. 훗날 더 깊게 공부해보자.  
> [참고 : https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/annotation/AutowiredAnnotationBeanPostProcessor.html](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/annotation/AutowiredAnnotationBeanPostProcessor.html)
