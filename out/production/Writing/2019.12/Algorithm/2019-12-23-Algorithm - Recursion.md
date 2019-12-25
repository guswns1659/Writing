## 목차
- Recursion이란?
- 다양한 재귀 함수
## 핵심
- **재귀는 원리를 이해하면 구현이 편해진다**

## Recursion(재귀)
재귀의 의미는 자기 자신을 다시 부르는 것을 의미한다. 함수에 적용하면 자기 자신을 다시 호출하는 함수를 말한다. 재귀 함수는 base case가 있어야 함수가 종료될 수 있다. 없다면 무한 루프를 만든다. 하지만 base case만 있다고 종료되는 것은 아니고 recursive case가 base case로 수렴해야 한다.

## 다양한 재귀 함수
### 0 ~ n까지의 합 구하기.
0 ~ n 까지의 합 = (0 ~ n-1 까지의 합 + n)이다. n = 0 이면 결과는 0이다. 이걸 코드로 구현해보자. **포인트는 n까지 합을 구하기 위해선 n-1까지 합과 n이 더해진다는 점** 이게 다른 재귀 함수에도 적용된다.
```java
public static int sum(int n) {
    if (n == 0) return 0;
    else return n + sum(n-1);
}
```

### factorial 함수 구현
```java
public static int factorial(int n) {
    if (n == 1) return 1;
    else return n * factorial(n-1);
}
```

### Fibonacci 함수 구현
```java
public static int Fibo(int n) {
    if (n < 2) return n;
    else return fibo(n-1) + fibo(n-2);
}
```

### power 함수 구현
```java
public static int power(int x, int n) {
    if (n == 0) return 1;
    else x * power(x, n-1);
}
```