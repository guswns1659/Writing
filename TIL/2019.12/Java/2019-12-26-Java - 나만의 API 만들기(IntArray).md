## 목차
- 나만의 API 만들기
- IntArray 만들기
## 핵심
- **API는 이해하고 사용하기에 조금 더 편하다.**

## 나만의 API 만들기
우리가 배열을 사용하고 싶으면 자바에서 기본으로 제공하는 배열을 사용하면 된다. 하지만 배열을 사용하기 위한 기본 문법은 다 알고 있어야 한다. 그걸 알지 못하면 사용하지 못한다.<br>
 이 때 배열과 비슷한 기능을 하는 API를 만들면 조금 더 **직관적으로** 배열을 사용할 수 있다. 메서드를 활용하기 때문에 조금 더 기능에 부합하게 메서드 이름을 만들 수 있다.

## IntArray 만들기
```java
// 정수형 배열 기능하는 API만들기
public class IntArray {
    private int count;
    private int[] arr;
    // 배열 생성
    public IntArray() {
        this(10);
    }
    public IntArray(int init) {
        arr = new int[init];
    }
    // 배열에 값 추가 : add
    public void add(int data) {
        System.out.println(count);
        arr[count++] = data;
    }
    // 배열에 값 얻기 : get
    public int get(int index) {
        return arr[index];
    }

    // 배열의 길이 구하기 : size
    public int size() {
        return count;
    }
}

```