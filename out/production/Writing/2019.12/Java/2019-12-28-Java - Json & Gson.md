## 목차
- 객체를 표현하는 3가지 방법
- Gson API로 JSON 다루기
## 핵심
- **Json으로 데이터 정보를 편리하게 주고 받을 수 있다.**

## 객체를 표현하는 3가지 방법
서로 다른 프로그램끼리 객체를 주고 받을 땐 문자열 형태로 주고 받는 것이 편하다. **왜냐하면 문자열은 각 언어 별 형태가 거의 비슷하기 때문이다. "" or ''** 문자열 데이터를 주고 받는 형식은 크게 3가지가 있다.
### 1. 의미는 없고 구분은 되어 있는 경우
```java
String textMember = "홍길동,광주,010-1111-1111#나길동,서울,010-3212-3213"
```<br>
데이터 표현은 단순하지만, 의미가 명확하지 않다. 우리는 사람이기 때문에 저 데이터가 어떤 기준으로 나뉘어졌는지 알 수 있지만, 컴퓨터는 정확히 파악하기 어렵다. 또한, 데이터를 분리하는 과정, 전처리 과정이 복잡해지는 단점이 있다.

### 2. 의미도 있고 구분도 되어 있는 경우 : XML(Extensible Markup Language)
```XML
<member>
    <name>홍길동</name>
    <address>광주</address>
    <phone>010-2222-3333</phone>
</member>
```<br>
확실히 이전 버전보다 의미도 있고 데이터 간 구분도 되어 있다. 태그로 구분되어 있기 때문에 데이터 처리는 쉽다. 하지만 데이터의 크기가 커지는 단점이 있다.

### 3. 의미도 있고 구분도 되어 있는 경우 : JSON(JavaScript Object Notation)
```javascript
String jsonMember = "[{"name" : "홍길동", "address" : "광주"}]" +
                    "[{"name" : "나길동", "address" : "서울"}]"
```<br>
XML보다 간결하다. 하지만 표현이 제한적인 단점이 있다. 하지만 간결함이 가장 큰 무기가 되서 최근엔 다양하게 사용되는 표기법이다.

## Gson API로 JSON 다루기
```java
        // Gson으로 객체를 json형식 문자열로 바꾸기
        BookDTO b = new BookDTO("java", 5000, "한빛미디어");
        Gson g = new Gson();
        String json = g.toJson(b);
        System.out.println(json);

        // Gson으로 json을 객체로 바꾸기
        BookDTO book = g.fromJson(json, BookDTO.class);
        System.out.println(book.toString());

        // Gson으로 List를 Json으로 바꾸기
        List<BookDTO> list = new ArrayList<>();
        list.add(new BookDTO("python", 1000, "note"));
        list.add(new BookDTO("c", 10000, "please"));
        String json2 = g.toJson(list);
        System.out.println(json2);

        // Gson을 활용하여 Json을 List로 바꾸기
        List<BookDTO> list2 = g.fromJson(json2, new TypeToken<List<BookDTO>>(){}.getType());
        for (BookDTO v : list2) {
            System.out.println(v);
        }
```<br>
Json을 List를 바꿀 땐 객체로 바꿀 때보다 복잡하다. 그 이유는 객체는 하나의 자료형이기 때문에 BookDTO.class라고 적으면 된다. 하지만 배열은 속에 객체라는 자료형이 ~~있기 때문에~~있어서 총 2개가 된다. 그래서 자바에게 확실하게 알려줘야 한다.