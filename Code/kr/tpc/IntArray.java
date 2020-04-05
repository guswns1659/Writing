package kr.tpc;

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
