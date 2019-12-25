## 목차
- 재귀 알고리즘 기본 조건
- 매개변수를 암시화(implicit)하지말고 명시화(explicit)하라
## 핵심
- **재귀 알고리즘 구현할 때 매개변수를 명시화하라.**

## 재귀 알고리즘 기본 조건
1. 프로그램이 끝나는 base case가 있어야 한다.
2. 재귀 알고리즘 영역이 base case로 수렴해야 한다.

## 매개변수를 암시화(implicit)하지말고 명시화(explicit)하라
왜? 재귀 알고리즘을 사용할 땐 자기 자신이 다시 호출되는 상황이 발생한다. 그 때 명시화된 매개변수는 호출할 때 다시 사용되기 때문이다. 한마디로 재귀 알고리즘 구현할 때 편해진다.

### 순차탐색(linear search)<br>
```java
    // Iterative linear search
    public static int IterLinearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }
    // Recursive linear search
    public static int RecurLinearSearch(int[] arr, int begin, int end, int target) {
        if (begin > end) return -1;
        else {
            if (arr[begin] == target) return begin;
            else {
                return RecurLinearSearch(arr, begin+1, end, target);
            }
        }
    }
```

### 최댓값 찾기(Recursive find max value)<br>
```java
    public static int findMax(int[] arr, int begin, int end) {
        if (begin == end) return arr[begin];
        else {
            return Math.max(arr[begin], findMax(arr, begin+1, end));
        }
    }
```

### 이진탐색<br>
```java
public static int binarySearch(String[] items, String target, int begin, int end) {
        if (begin > end) return -1; // 길이가 0인 경우
        else {
            int middle = (begin + end) / 2;
            int compResult = target.compareTo(items[middle]);
            if (compResult == 0) return middle;
            else if (compResult < 0) return binarySearch(items, target, begin, middle-1);
            else return binarySearch(items, target, middle+1, end);
        }
    }
```