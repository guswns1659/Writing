## 목차
- ObjectArray
- 실습
- 이미 ArrayList는 있다.

## 핵심
- **Object을 이용하면 upCasting, downCasting을 생각해라**

## ObjectArray
지난 시간에 만든 intArray는 int 자료형 데이터만 넣을 수 있다. 이러면 아쉬움이 남는다. 그럼 모든 자료형을 담을 수 있는 배열을 어떻게 만들 수 있을까? **모든 자료형을 upCasting으로 받을 수 있는 Object 배열로 만들면 어떨까?**<br>
또한, Object 객체로 배열을 만든다는 것은 데이터가 들어갈 때는 upCasting으로 나올 때는 downCasting으로 나온다는 의미다. 이걸 자유자재로 사용할 수 있어야 한다.

## 실습
```java
public class ObjectArray {
    private int count;
    private Object[] arr;
    // 배열 생성
    public ObjectArray() {
        this(10);
    }
    public ObjectArray(int init) {
        arr = new Object[init];
    }
    // 배열에 값 추가 : add
    public void add(Object data) {
        arr[count++] = data;
    }
    // 배열에 값 얻기 : get
    public Object get(int index) {
        return arr[index];
    }

    // 배열의 길이 구하기 : size
    public int size() {
        return count;
    }
}
```
## 이미 ArrayList는 있다.
우리가 구현한 ObjectArray보다 기능이 더 많은 ArrayList가 자바에선 기본 API로 제공하고 있다. 똑같이 Object 배열로 이루어져있지만 크기가 제약이 없기 때문에 더 유용하다. 하지만 어떤 구조 이루어져 있는지 이해하는 것도 중요하다.
