## 목차
- 인터페이스와 추상클래스의 차이
- 상수가 올 수 있다.
- 인터페이스와 인터페이스의 상속 관계
- 다중 상속 관계 구현하기
## 핵심
- **인터페이스는 다형성을 100% 보장하기 위해 사용한다.**
- **인터페이스는 자식 클래스를 100% 핸들링할 수 있다**

## 인터페이스와 추상클래스의 차이
인터페이스는 모든 메서드가 추상 메서드인 클래스를 말한다. 추상 클래스와의 차이는 모든 메서드가 추상 메서드라는 점이다. 즉, 구현 메서드는 절대 정의할 수 없다. 그럼 **왜?** 인터페이스와 추상 클래스는 나눴을까?<br>

인터페이스는 서로 다른 기능을 가진 자식 클래스를 모아 다형성을 이용할 때 필요하다. 왜냐하면 구현 메서드가 없기 때문에 모든 자식 클래스에 적용되는 기능이 없다는 말이다. 각자 자식 클래스에서 부모의 메서드를 자기에게 맞게 override하면 된다.<br>

추상 클래스는 기능이 비슷한 자식 클래스를 모아 다형성을 이용할 때 필요하다. 추상 클래스는 추상 메서드를 가질 수 있지만 모든 메서드가 100% 추상 메서드는 아니다. 구현 메서드로 자식 클래스 전체에 해당하느 기능은 정의할 수 있다. <br>

### 예시<br>
```java
public interface RemoCon {
    int MAXCH =100;
    int MINCH = 1;

    void chUp();
    void chDown();
    void internet();
    
    RemoCon r = new TV();
    r.chDown();
    r.chUp();
    r.internet();
    System.out.println(RemoCon.MAXCH);
}
```
## 상수가 올 수 있다.
인터페이스는 모든 메서드가 추상 메서드이기 때문에 객체 생성이 불가능하다. 그래서 상수를 사용하려면 **인터페이스이름.상수이름** 이렇게 표기해야한다. 이와 관련해서는 [private생성자 <- 여기로](https://guswns1659.tistory.com/42)<br>
```java
RemoCon.MAXCH // 인터페이스 RemoCon의 상수 MAXCH
```
## 인터페이스와 인터페이스의 상속 관계
인터페이스끼리도 상속을 할 수 있다. 그 때 extends 키워드를 사용한다. 만약 다른 인터페이스를 상속받은 인터페이스가 있다고 하자. 이 인터페이스 implements하는 클래스는 모든 인터페이스의 메서드를 override 해야한다.<br>
```java
public interface A {
    public void x();
}
public interface B extends A {
    public void y();
}
public class C implements B {
    public void x() {
        재정의
    }
    public void y() {
        재정의
    }
}
B r = new c();
```
## 다중 상속 관계 구현하기
자바에서 클래스는 한 번의 상속만 가능하다. 하지만 인터페이스가 있다면 다중 상속이 가능하다. 그럼 **왜 다중 상속이 필요할까?**<br>
예를 들어, Dog라는 클래스를 설계하려고 할 때 Dog는 Animal도 되고, Pet도 되고, Robot도 가능하다. 그렇기 때문에 하나의 종류만 확정할 수 없다. 각 종류에 맞게 인터페이스를 구현하면 훨씬 정교하게 Dog를 설계할 수 있다.<br>
```java
public class Dog extends Animal implements Pet, Robots {

}
```