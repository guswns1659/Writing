## 목차
- Wrapper Class(포장 클래스)란?
- Boxing & UnBoxing

## 핵심
- **자바는 자동으로 포장도 해주고 풀어 주기도 한다.**

## Wrapper Class(포장 클래스)란?
Wrapper Class는 기본 자료형을 객체 자료형으로 포장하는 클래스이다. 즉, 바꿔 준다는 의미이다. **왜 바꿔야 할까?** 기본 자료형을 객체 자료형으로 만들면 상속, 다형성 등 객체를 유용하게 사용할 수 있다.<br>
### 예시
- int -> Integer
- float -> Float
- char -> Character
- boolean -> Boolean

## Boxing & UnBoxing
만약, Object[]에 int를 넣고 싶으면 어떻게 넣을 수 있을까? **원래는 못 넣는다. 자료형이 다르기 때문이다.** 하지만 int를 Integer로 포장해서 객체로 만들면 Object[]에 들어갈 수 있다. 그렇다면 아래 코드처럼 써야 한다.<br>
```java
Object[] obj = new Object[2];
obj[0] = new Integer(10);
obj[1] = new Integer(10);
```<br>

하지만 자바에서는 int로 적어도 자동으로 Integer로 포장(Boxing)해서 배열에 넣어 준다.<br>
```java
obj[0] = 1; // 1을 자동으로 Boxing(포장)해서 Integer로 바꿔 준다.
```<br>
그래서 Boxing은 int 자료형을 자동으로 Integer로 바꿔 주는 기능을 말한다.<br>
Unboxing은 Integer 객체를 자동으로 int 자료형으로 바꿔 주는 기능이다. (포장을 풀다)<br>
```java
Integer i = 3; // Boxing
int i = new Integer(3); // unboxing
```
