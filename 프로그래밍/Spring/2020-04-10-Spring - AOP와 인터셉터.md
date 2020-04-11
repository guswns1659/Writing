## 1. 개요 
스프링 인터셉터에 대한 개념 정리 및 실습 

## 2. AOP와 인터셉트
AOP는 관점 중심 프로그래밍으로 애플리케이션 코드에서 중복으로 발생하는 코드를 처리하는 기술이다. 프로그램의 로직을 다양한 관점으로 나누고 그 관점별로 모듈을 만드는 프로그래밍 방법이 AOP다. 

### 2.1 AOP 관련 용어 
-   target : AOP를 적용할 대상
-   advice : target에 제공할 부가 기능을 담은 클래스
-   pointcut : advice가 적용되는 위치
-   joinpoint : advice가 적용될 수 있는 위치. pointcut은 넓은 의미에서 joinpoint의 부분집합이다. 

### 2.2 인터셉터 
스프링 부트에서 제공하는 AOP를 실행할 클래스이다. AOP 구현체라 이해할 수 있다. 기본 스프링에서는 조금 더 복잡하지만 스프링 부트에서는 더욱 간단하게 인터셉터를 사용할 수 있다. 

## 3. 인터셉터 실습
- 호눅스 코드로 실습하고 싶으면 여기로 [호눅스 깃허브 주소 : https://github.com/honux77/spring-boot-playground/commits/master](https://github.com/honux77/spring-boot-playground/commits/master) 들어간 뒤 해당 커밋 보면서 따라해본다. 
- 이번 ToDo 프로젝트에서 어떻게 인터셉터를 적용했는지 살펴보자.

### 3.1 의존성 추가
- 스프링부트에서는 spring-boot-starter-web이 있으면 사용 가능하다. 

```shell script
implementation 'org.springframework.boot:spring-boot-starter-web'
```

- aspectJ 사용하고 싶을 땐 아래 의존성을 추가. 스프링부트에서는 aspectJ가 필요없다. 

```shell script
implementation 'org.aspectj', name: 'aspectjrt', version: '1.9.5'  
implementation 'org.aspectj', name: 'aspectjweaver', version: '1.9.5'
```

### 3.2 인터셉터 적용 순서 
#### 3.2.1 인터셉터를 생성 
- 아래 코드를 보며 설명한다. 
- 먼저 인터셉터가 HandlerInterceptorAdapter를 상속한다. 
- preHandle 메서드에 target 메서드(이번 프로젝트에선 모든 메서드)가 실행 전에 수행할 기능을 적는다. 
    - 아래 코드는 로그인한 사용자인지 확인하는 코드이다. 쿠키에 담겨서 넘어온 JWT를 parsing 한 뒤 userId가 DB에 있는 userId인지 확인하는 코드. 
- postHandle에서는 target 메서드가 실행된 후 수행할 기능을 적는다. 
    - 이번 프로젝트에서는 postHandle의 역할은 아직은 없는 걸로 파악된다. 
 

```java
package com.codesquad.todo1.Utils;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Autowired
    private TodoService todoService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object Handler) {
        Cookie[] cookies = request.getCookies();
        Cookie cookie = null;
        for (Cookie each : cookies) {
            if (each.getName().equals("sunny_jwt")) cookie = each;
        }
        assert cookie != null;
        String jwt = cookie.getValue(); // 쿠키 중 jwt를 얻는다.
        String jwtUserId = JwtUtils.jwtParsing(jwt); //jwt 파싱
        try {
            todoService.getUser(jwtUserId).orElseThrow(AuthorizationFail::new); // userRepository에 jwt 속 userId가 있는지 확인한다. 
        } catch (Exception e) {
            request.setAttribute("jwt", false);
            return true;
        }
        logger.info("cookie : {}", jwt);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object Handler,
                           ModelAndView modelAndView) {
        logger.info("after");
    }
}

```

### 3.2.2 타켓 메서드를 생성 
- 인터셉터를 생성한 후에는 인터셉터를 적용할 타켓 메서드를 생성한다. 이번 프로젝트에서는 login 메서드를 제외한 모든 메서드가 타켓메서드가 된다. 
- 로그인 메서드가 포함되지 않는 이유는 처음 로그인할 때는 jwt가 만들어지지 않았기 때문에 인터셉터를 적용하지 않는다. jwt는 처음 로그인을 성공하면 만들어진다. 
- 이번 target 메서드는 hello 메서드로 가정한다. 

```java
@GetMapping("/hello")
    public ApiShowList hello(HttpServletRequest request) {
        boolean authorization = (boolean) request.getAttribute("jwt");
        if (!authorization) {
            return new ApiShowList(401);
        }
        return new ApiShowList(200);
    }
```

### 3.2.3 인터셉터를 WebConfig에 등록한다. 
- 인터셉터를 사용하려면 IoC 컨테이너에 빈으로 등록해야 한다. 
- 아래 코드를 보면 LoginIntercepter가 빈으로 등록된게 보인다. 
- 인터셉터를 빈으로 등록하면 이제 target메서드에 인터셉터를 적용해야 한다. 
- 마지막 addInterceptors 메서드를 통해 인터셉터를 적용할 메서드와 제외할 메서드를 적으면 된다. 
    - 이번 프로젝트에서는 로그인을 담당하는 메서드를 제외하고 모든 메서드에 인터셉터를 적용한다.

```java
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*");
    }

    @Bean
    public LoginInterceptor loginInterceptor() {
        return new LoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/api/login");
    }
}
```

### 3.3 인터셉터 결과 
- 이제 인터셉터이 잘 적용했는지 확인하기 위해 테스트를 진행한다. 
- 인터셉터의 preHandle에 아래 코드를 추가한다. 

```java
        logger.info("target 메서드 전에 실행??");
```

- target 메서드(hello)에 아래 코드를 추가한다. 

```java
        logger.info("target 메서드 실행!");
``` 

- 인터셉터의 postHandle에 아래 코드를 추가한다. 

```java
        logger.info("target 메서드 후에 실행??");
```

- 인터셉터가 정상적으로 적용되면 아래 결과가 나온다. 

```java
2020-04-11 16:22:24.597  INFO 7246 --- [nio-8080-exec-2] c.c.todo1.Utils.LoginInterceptor         : target 메서드 전에 실행??
2020-04-11 16:22:24.695 DEBUG 7246 --- [nio-8080-exec-2] o.s.jdbc.core.JdbcTemplate               : Executing prepared SQL query
2020-04-11 16:22:24.696 DEBUG 7246 --- [nio-8080-exec-2] o.s.jdbc.core.JdbcTemplate               : Executing prepared SQL statement [select user from User u where u.user_id = ?]
2020-04-11 16:22:24.918  INFO 7246 --- [nio-8080-exec-2] c.c.todo1.controller.TodoController      : target 메서드 실행!
2020-04-11 16:22:24.997  INFO 7246 --- [nio-8080-exec-2] c.c.todo1.Utils.LoginInterceptor         : target 메서드 후에 실행??
```



	