## 1. 개요
어노테이션만으로 객체들이 ioC컨테이너에 빈으로 등록될 수 있는 기능이 ComponentScan이다. 스프링 5.1부터 적용된 이 기술을 한번 살펴보자.
## 2. @ComponentScan이란 
@ComponentScan이란 스프링에서 @Component이 붙은 객체를 IoC 컨테이너의 빈으로 등록해주는 기술이다. 
### 2.1 @ComponentScan 시작 지점 
@ComponentScan을 가지고 있는 클래스가 속한 패키지에서부터 컴포넌트 스캔이 시작된다. 

- 아래 코드를 보면 @ComponentScan은 스프링부트가 시작하는 @SpringBootApplication에 들어가있다. 

```java
@SpringBootApplication
@PropertySource("classpath:/app.properties")
public class SpringcoreApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringcoreApplication.class, args);
    }
}
```

- @SpringBootApplication을 따라가보니 아래 코드처럼 @ComponentScan이 존재한다. 그러면 스프링부트의 컴포넌트 스캔은 해당 클래스의 패키지부터 시작한다. 

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan(excludeFilters = { @Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
		@Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })
public @interface SpringBootApplication {
```

### 2.2 ComponentScan을 제외할 필터.
- 컴포넌트 스캔 범위에 있어도 지정 타입을 빈으로 등록하지 않는 기능도 존재한다. 아래 코드에 존재하는 excludeFilters이다. 

```java
@ComponentScan(excludeFilters = { @Filter(type = FilterType.CUSTOM, classes = TypeExcludeFilter.class),
		@Filter(type = FilterType.CUSTOM, classes = AutoConfigurationExcludeFilter.class) })
```

### 3. Component를 실행하는 객체는?
- 컴포넌트 스캔은 어떤 객체가 동작하는걸까? 바로 BeanFactoryPostProcessor이다. 설정 파일로 등록하는 빈보다 먼저 컴포넌트 스캔이 일어나서 빈으로 등록된다.  
- [자세한 내용 : 스프링 공식문서](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/beans/factory/config/BeanFactoryPostProcessor.html)
