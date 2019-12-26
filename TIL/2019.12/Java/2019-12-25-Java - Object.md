## 목차
- Object Class
- toString()
## 핵심
- **Object는 부모의 부모의 부모다.**

## Object Class
Object 클래스는 **모든 클래스의 root클래스이다** ~~부모의 부모의 부모~~ 기본적으로 하나의 클래스가 생성되면 자연스럽게 Object의 상속을 받는다. 즉, Object 클래스가 가진 기능을 활용할 수 있다. ~~많지는 않다~~<br>
하지만 상속, 다형성 이론 배운 상황에서는 Object 클래스를 활용해서 조금 더 확장해서 사용할 수 있다.<br>
처음 클래스가 생성되면 생략되는 코드가 3곳이 있다.<br>
1. **import java.lang.\*** -> Object 클래스가 있는 패키지
2. **public class A extends Object {** -> extends 키워드
3. **public A() { super() }** -> Object 생성자를 호출하는 생성자 메서드

## toString()
모든 클래스는 Object 클래스를 상속받기 때문에 toString()를 사용할 수 있다. 만약 클래스에서 toString() 메서드를 정의하지 않으면 Object의 toString()을 사용하게 되는데, 이 때는 객체의 메모리 주소(address)가 나온다.<br>
하지만 자체적으로 toString()을 정의했다면 그 클래스의 toString()이 구현된다. Object 것이 아닌.

## Object class 활용(다형성 인수, 다형성 배열)
Object 클래스로 자식 객체를 핸들링하기 위해선 upCasting으로 객체를 생성해야 한다. 그 뒤 downCasting을 해서 자식 객체 메서드에 접근해야 한다.<br>
**약간 번거롭지만 이렇게 사용하는 이유는?** 내가 자식 객체의 기능을 다 알고 있다면 upCasting을 안하고 자식 객체를 생성하면 된다. 하지만 API를 사용하는 경우 그 속에 기능을 모르기 때문에 부모 클래스를 이용해야 한다.<br>
게다가 Object 클래스는 메서드가 다양하지 않기 때문에 override도 한계가 있다. downCasting은 필수이다.

### 1. 다형성 인수
```java
    public static void main(String[] args) {
        // 1. 다형성 인수
        A a = new A();
        display(a);
        B b = new B();
        display(b);
    }

    private static void display(Object o) {
        if (o instanceof A) {
            ((A)o).go();
        } else {
            ((B)o).go();
        }
    }
```

### 2. 다형성 배열
```java
    Object[] o = new Object[2];
    o[0] = new A();
    o[1] = new B();
    for (Object value : o) {
        if (value instanceof A) {
            ((A) value).go();
        } else {
            ((B) value).go();
        }
    }
```