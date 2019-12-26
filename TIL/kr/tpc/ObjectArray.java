package kr.tpc;

// Object 배열 기능하는 API만들기
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
