## 1. 개요 

## 2. IoC 컨테이너
### 2.1 IoC 컨테이너란  
- Bean Factory : IoC 컨테이너의 최상위 인터페이스. 다양한 구현체가 있다. 
### 2.2 IoC 컨테이너의 장점   
- IoC 컨테이너의 장점 
	- 의존성 관리 : IoC 컨테이너에 등록된 빈 객체는 의존성을 쉽게 주입받을 수 있다. 
	- 싱글톤 스코프 : IoC 내 빈은 싱글톤 형식?으로 하나의 인스턴스를 생성하고 그 인스턴스를 복제하는 형식. 메모리 관리 측면에서 유리.  
	- 라이프사이클 인터페이스 : 
	
## 3. ApplicationContext
## 3.1 ApplicationContext란
> Central interface to provide configuration for an application. This is read-only while the application is running
, but may be reloaded if the implementation supports this. [참고 : 공식문서](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/context/ApplicationContext.html)
 
> 애플리케이션의 설정 파일을 제공하는 핵심적인 인터페이스이다. 애플리케이션이 실행될 때는 오직 읽기 전용이지만, 만약 구현체가 지원한다면 다시 로딩된다. 
	
## 3.2 ApplicationContext 생성하는 방식의 변화
- 과거 빈을 만드는 방식, 스프링 config.xml : 단점은 매번 빈 등록 시 입력해야 함.
- componentScan 방식 : 스프링 2.5부터 도입된 방식

```java
<context:component-scan base-package="com.spring.springcore"/>
```
	
- @Service와 @Repository : @Component를 확장한 애노테이션
- java config로 빈 설정파일 등록 : 

```java
@Configuration
public class ApplicationConfig {

    @Bean
    public BookRepository bookRepository() {
        return new BookRepository();
    }

    @Bean
    public BookService bookService(BookRepository bookRepository) {
        BookService bookService = new BookService();
        bookService.setBookRepository(bookRepository);
        return bookService;
    }
}
```

- java config로 빈 설정 파일도 @ComponentScan 추가.

- 스프링 부트로 프로젝트를 시작하는 이유 : 

## Bean
### Bean이란
빈은 IoC컨테이너가 관리하는 객체를 의미한다. 컨테이너는 내부에 있는 빈에 의존성 주입을 할 수 있다.

### 어떻게 컨테이너 넣는가? 
어떻게 객체를 컨테이너 안에 넣어 빈으로 만들까? 두 가지 방법이 있다고 한다.
- Component scanning 
	- 의미 : @Component가 붙은 모든 객체를 IoC컨테이너에 추가한다. 
	- @ComponentScanning이 붙은 패키지의 하위 객체을 스캐닝하며 컨테이너에 추가한다. 
	- 예 : @Controller, @Configuration ... 
- 직접 XML or Configuration 파일로 만든다.

```java
@Configuration  
public class SampleConfig {  
  @Bean  
  public SampleController sampleController() {  
  return new SampleController();  
}
``` 

### 어떻게 컨테이너에서 꺼내서 쓰는가? 
- 직접 빈을 만들어서 사용한다. 
- @Autoweired를 사용해 IoC컨테이너에서 관련 빈을 찾아 의존성 주입하도록 한다. (추천)
