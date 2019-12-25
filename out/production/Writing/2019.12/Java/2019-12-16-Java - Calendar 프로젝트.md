## Scanner
- 스캐너 사용 후엔 scanner.close() 해줘야 한다.
- nextLine()은 한번에 입력받은 문자열을 가져온다. 보통 split()과 같이 써야한다.
- next()는 공백을 기준으로 문자열을 가져온다.
- 스캐너를 다시 쓰고 싶을 땐 Scanner 클래스를 다시 만드는 것이 아니라 한번 만들었던 scanner를 사용하면 된다.

## 상수 설정
```java
private static final int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
```

## noSuchElementException
- Scanner를 한번 사용하고 close() 해놓으니 반복해서 사용할 때 에러 발생.
