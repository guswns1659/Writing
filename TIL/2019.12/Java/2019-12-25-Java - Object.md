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