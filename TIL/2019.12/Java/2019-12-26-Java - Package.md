## 목차
- Package(패키지)란?
- 외부에서 package 내부 클래스에 접근하는 방법
- Default 접근권한
## 핵심
- **Package는 여러 클래스를 모아 놓은 가방이다.**

## Package(패키지)란?
패키지는 여러 클래스를 모아 놓은 단위를 말한다. 그럼 **왜** 패키지를 사용할까? 여러가지 이유가 있지만 간추려서 2가지가 있다.<br>
1. 기능이 비슷한 클래스를 모아서 관리를 쉽게 하기 위함
2. 외부로 부터 접근을 막기 위함 (1번에 비해 빈도 수가 떨어진다.)
마치 가방이라고 생각하면 된다. 가방은 비슷한 물건끼리 넣을 수 있고, 외부로 부터 물체를 보호할 수 있다. 패키지도 이와 마찬가지다. 하지만 외부로 부터 접근을 막는 목적으로 자주 사용되지 않는다. 왜냐하면 클래스를 만드는 목적이 외부와 공유하기 위해 만든 목적일 가능성이 크기 때문이다. 그런데 공유가 안된다면 기능이 제대로 발휘하지 못하는 것이다.<br>
또한, 패캐지가 다르면 메서드의 이름이 같아도 된다. 오버로딩이 허용된다.

## 외부에서 package 내부 클래스에 접근하는 방법
- class full name을 알아야 한다. (root package부터 경로가 적인 이름)
- 접근 권한을 알아야 한다. (public 인지 private, dafault ...)
- import를 활용하면 편하다.

## Default 접근권한
package가 명시적으로 선언되어 있고 클래스 앞에 접근자가 생략되면 public이 아니라 default 접근 권한을 가진다. 이 의미는 **패키지 바깥에서 아무나 클래스에 접근할 수 없다는 말이다.** 왜냐면 패키지의 기능 중 하나가 외부로부터 클래스를 보호하는 역할도 있기 때문이다.
```java
package kr.tpc;

class A { // default 접근 권한을 가진다.
}
```