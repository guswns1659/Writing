[참고 : 윤성우의 열혈 JAVA 프로그래밍]

## 예외란
프로그램 실행 중에 발생하는 예외적인 상황을 줄여서 예외라고 한다. 문법의 오류가 아니라 실행 중간에 발생하는 정상적이지 않는 상황을 말한다.

## 예외 처리란 예외 클래스의 인스턴스를 처리하는 것
자바는 예외 상황별로 그 상황을 알리기 위한 클래스를 정의하고 있다. 이러한 클래스를 가르켜 예외 클래스라고 한다. 예외가 발생하면 가상머신은 그 예외 클래스의 인스턴스를 생성한다. 만약 사용자가 예외 클래스의 인스턴스를 처리한다면 프로그램은 종료하지 않는다. 보통 try - catch문을 통해 예외 처리를 한다.

```java
public class test {
    try {
        // 예외 관찰 영역
    } catch(Exception name) {
        // 예외 처리 영역 
    }
}
```

위 코드의 try 영역에서 예외가 발생하면 그 예외 인스턴스가 catch메서드의 매개변수로 들어간다. 예외가 발생하면 그 이후 코드는 실행되지 않고 바로 catch로 넘어간다.

## 예외처리 책임 전가
예외 클래스의 최상위 클래스는 java.lang.Throwable이다. 이 클래스에는 발생한 예외의 정보를 알 수 있는 메서드가 정의되어 있는데, 대표적인 메서드는 public String getMessage(), public void printStackTrace() 이다. <br>
만약 프로그램이 main() -> method1() -> method2() 순서로 실행된다고 하자. 만약 맨 마지막에 실행되는 method2()에서 예외가 발생하면 그 예외 인스턴스를 method2()를 호출한 method1()으로 넘긴다. 그 다음은 main()으로 보낸다. 각 예외 인스턴스를 전가할 때 예외처리를 하지 않으면 최종적으로 가상머신까지 넘어가 가상머신이 처리한다. 이렇게 되면 프로그램은 종료된다.

## 예외 클래스의 구분
예외 클래스의 최상위 클래스는 Throwable이다. 이를 상속하는 예외 클래스는 3가지이다.
- Error 클래스를 상속하는 예외 클래스
- Exception클래스를 상속하는 예외 클래스
- RuntimeException을 상속하는 예외 클래스, RuntimeException은 Exception 클래스를 상속한다.
이 중 Error 예외 클래스는 예외를 넘어서서 Error이다. 가상머신에 문제가 생겼다거나, 컴퓨터가 물리적으로 문제가 생겼을 때 발생한다. 이 때 예외처리를 하는 것이 아니라 문제 발생원인을 살펴봐야 한다.<br>
RuntimeException 클래스를 상속하는 클래스는 'ArithmeticException', 'ClassCastException' 등이 있다.

## Exception을 상속하는 예외 클래스의 예외처리
Error를 상속하거나 RuntimeException을 상속하는 예외의 발생은 코드 작성 과정에서 특별히 무언가를 하지 않아도 된다. 그러나 Exception을 상속하는 예외의 발생에 대해서는 try ~~ catch문 또한 throws 선언을 통해서 예외의 처리를 넘긴다는 표시를 꼭 해야 한다. ex) IOException

## 사용자가 정의하는 예외
사용자가 직접 예외클래스를 지정할 수 있다. 이 때 Exception을 상속해야 한다.

```java
class ReadAgeException extends Exception {
    public ReadAgeException() {
        super("유효하지 않은 나이가 입력되었습니다.");
    }
}
```

위 코드에서 예외가 발생하면 슈퍼 타입을 생성하면서 정의한 예외처리 메세지를 보낸다. 그 때 예외 인스턴스에서 getMessage()를 사용하면 저 예외 메세지가 출력된다.


## try ~~ catch ~~ resources문
try ~~ resources문은 종료가 필요한 객체를 사용할 때 자동으로 종료를 해주는 문법이다. IO스트림을 사용한 후에 close()를 무조건 해줘야 하는데 try ~~ resources문을 사용하면 자동으로 close() 된다.

```java
import java.io.BufferedWriter;
class TryWithResouce {
    public static void main(String[] args){
      Path file = Paths.get("C:\\javastudy\\Simple.txt");
      
      try (BufferedWriter writer 
                = Files.newBufferedWriter(file) ) {
          writer.write('A');
          writer.write('B');
      } catch (java.io.IOException e) {
          e.printStackTrace();
      }
    }
}
```

위 코드에서 try(resources)가 실행되면 자동으로 close()가 작동된다. 하지만 close()이외에 메서드는 작동하지 않는다.
