[참고 : 동빈나 영상](https://www.youtube.com/watch?v=ARi-cXdIIj8)

## Swagger 
### Swagger란? 
- 클라이언트 개발자와 백엔드 개발자가 소통하는 방법을 기록한 API 명세서
- OpenApi : RestAPI를 위한 표준 명세 규격을 의미. 어떻게 데이터 타입으로 주고 받을지 소통하는 방법. 

### Spring boot에서 사용법 
- Swagger 라이브러리 추가하기 

```java
compile group: 'io.springfox', name: 'springfox-swagger2', version: '2.9.2'  
compile group: 'io.springfox', name: 'springfox-swagger-ui', version: '2.9.2'
```

- Spring이 시작되는 어플리케이션에 @EnableSwagger2를 붙인다. 
- 관련 설정을 추가한다. 

```java
@Bean
    public Docket swaggerApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(swaggerInfo()).select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.ant("/api/**"))
                .build();
    }

    private ApiInfo swaggerInfo() {
        return new ApiInfoBuilder().title("Spring API Documentation")
                .title("Java Q&A API")
                .description("코드스쿼드 Java-qna API 문서")
                .license("Sunny")
                .version("1")
                .build();
    }
```

- Controller의 리턴값을 view로 하면 swagger에서 view로 보내준다. 

### SwaggerHub 이용하는 방법
