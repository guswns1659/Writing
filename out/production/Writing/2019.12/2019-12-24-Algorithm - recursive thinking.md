## 목차
- 재귀적 사고
- 간단한 재귀 함수들
## 핵심
- **재귀적 사고도 프로그램을 바라보는 관점 중 하나이다.**

## recursive thinking(재귀적 사고)
절차 지향 프로그램, 객체 지향 프로그램처럼 프로그램을 바라보는 관점 중 하나이다.

## 간단한 재귀 함수들
### 문자열의 길이 구하기<br>
```java
    // 문자열의 길이 구하는 재귀 함수
    private static int printLength(String str) {
        if (str.equals("")) return 0;
        else {
            return 1 + printLength(str.substring(1));
        }
    }
```

### 문자열의 프린트<br>
```java
    // 문자열 프린트하는 재귀 함수
    public static void printChars(String str) {
        if (str.length() == 0) return;
        else {
            System.out.print(str.charAt(0));
            printChars(str.substring(1));
        }
    }
```

### 문자열 뒤집어 프린트<br>
```java
    // 문자열 뒤집어 프린트
    private static void printReverseChars(String str) {
        if (str.length() == 0) return;
        else {
            printReverseChars(str.substring(1));
            System.out.print(str.charAt(0));
        }
    }
```
### 이진수로 변환해서 프린트
```java
    public static void printInBinary(int n) {
        if (n < 2) System.out.print(n);
        else {
            printInBinary(n / 2);
            System.out.print(n % 2);
        }
    }
```
### 배열의 합 구하기
```java
    public static int calcArrSum(int n, int[] arr){
        if (n <= 0) return 0;
        else {
            return arr[n-1] + calcArrSum(n-1, arr);
        }
    }
```