## 목차
- 객체를 생성하지 않고 메서드를 사용하는 법
- 인스턴스 메서드와 클래스 메서드
## 핵심
**private 생성자 메서드를 사용하려면 모든 메서드에 static 키워드가 있어야한다.**

## 객체를 생성하지 않고 메서드를 사용하는 법
생성자는 public과 private 둘 다 사용 가능하다. public 키워드가 있으면 다른 클래스에서 객체를 생성할 수 있다. 하지만 private이면 객체 생성을 할 수 없다. 왜냐면 생성자에 접근할 수 없기 때문이다. 그러면 private 생성자가 있는 객체의 메서드를 사용하려면 어떻게 해야할까? 이 말은 `객체를 생성하지 않고 메서드를 어떻게 사용할까?`와 같은 말이다.

## 인스턴스 메서드와 클래스 메서드
메서드는 인스턴스 메서드와 클래스 메서드로 나눠진다. 둘의 차이는 static이 있느냐 없느냐의 차이이다. 인스턴스 메서드는 static이 없기 때문에 반드시 new 연산자로 객체를 생성해야 사용할 수 있다. 하지만 클래스 메서드는 static이 있기 때문에 new 연산자로 객체를 생성하지 않더라도 메모리에 로딩될 수 있다. 즉, 사용할 수 있다. 방법은 클래스의 이름으로 접근하는 방법이다. 클래스의 이름으로 접근하는 그 순간, static이 있는 메서드는 메모리에 로딩이 되고 호출이 된다.

결국, 객체를 생성하지 않고 메서드를 사용하는 방법은 모든 멤버함수에 static을 붙여준다.

```java
Math.random() // Math도 private 생성자가 있지만 멤버함수가 static이기에 (클래스명.메소드)로 사용 가능하다.
System.out.println() // System도 마찬가지로 멤버함수에 static이 있어서 (클래스명.메소드)로 사용 가능하다.
```

자주 사용하는 클래스면 모든 멤버함수에 static을 붙이면 빠르게 사용할 수 있다.