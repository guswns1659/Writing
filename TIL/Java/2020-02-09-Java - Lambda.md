## 목차
- 람다란?
- 람다식 인자 전달 
- 람다가 필요한 순간은?
- 람다식의 다양한 표현
- 함수형 인터페이스와 어노테이션
- 람다식과 제네릭

## 람다란?
람다식은 컴파일러가 구별할 수 있는 수준만 남기고 다 생략하는 기법을 말한다. 익명클래스로 간단해진 코드를 더 간단하게 만들어준다. 익명 클래스란 클래스의 정스의 없이 인스턴스를 생성하는 클래스를 말한다. 클래스 생성이 없이 때문에 클래스의 이름이 없다. 그래서 익명이다. 익명 클래스를 생략하면 람다식이 만들어진다는 100% 정답은 아니지만 사용자 관점에서는 큰 차이가 없다.<br>

## 람다식 인자 전달
만약 어떤 인터페이스의 참조변수를 람다식으로 생성한다면 그 람다식은 그 인터페이스가 인자인 메서드의 인자로 전달될 수 있다. 무슨 말이냐 한번 살펴보자.  
 
 ```java
public class LambdaMain {
    public static void main(String[] args) {
        printTest(s -> System.out.println(s));
    }

    private static void printTest(Printable printable) {
        printable.print("string");
    }
}

interface printable {
    void print(String string);
}
```
 
위 코드의 printTest 메서드는 인자가 Printable이다. 그래서 main 메서드에서 호출될 때 들어오는 인자는 람다식이다. 이런 방식이 람다식으로 인자를 전달하는 방법이다. 

## 람다가 필요한 순간은?
그러면 무작정 람다를 남발하면 될까? 가독성이 높아지니까? 아니다. 람다가 필요한 순간에 적절하게 사용해야 한다. 그럼 람다는 언제 필요할까? 람다식은 기능(메서드) 하나가 필요한 상황에 사용할 수 있다. 무슨 말이냐. 어떤 객체의 메서드가 필요하면 인스턴스를 생성해서 전달해야 한다. 나는 기능 하난가 필요한데 인스턴스까지 생성해야 한다. 이 때 람다식으로 메서드만 전달할 수 있다.<br>

## 람다식의 다양한 표현
람다식은 어디까지 생략할 수 있을까? 매개 변수랑 메서드의 몸체가 각각 하나라면 중괄호와 소괄호의 생략이 가능하다. 

```java
public class test{
    Printable printable = s -> System.out.println(s); 
}
```

하지만 매개변수와 메서드의 몸체가 둘 이상인 경우 중괄호와 소괄호는 생략할 수 없다. 

```java
public class test {
    Calculate calculate = (a, b) -> System.out.println(a+b);
}
```

return문은 중괄호가 생략불가이다. 하지만 연산 결과가 남으면 별도로 생략해도 된다. 주로 생략해서 사용한다. 

```java
public class test {
    Calculate calculate = (a, b) -> {return a + b };
    Calculate calculate = (a, b) -> a + b;

}
```

매개 변수가 없을 때는 빈괄호로 명시를 해줘야 한다. 

### 함수형 인터페이스와 어노테이션(@FuntionalInterface)
함수형 인터페이스는 추상메서드가 하나인 인터페이스를 말한다. 그냥 메서드가 여러개 있어도 되지만 추상메서드는 하나만 존재해야 한다. 어노테이션을 통해 컴파일러에게 이 인터페이스가 함수형 인터페이스인지 확인을 부탁할 수 있다. @FuntionalInterface 이다. 

### 람다식과 제네릭
인터페이스가 제네릭 기반이라 하여 특별히 신경 쓸 부분은 없다. 타입 인자가 결정되면 추상 메서드의 T는 결정이 된다. 