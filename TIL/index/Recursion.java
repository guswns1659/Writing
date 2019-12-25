package index;

public class Recursion {
    public static void main(String[] args) {
        int sum = sum(2, 10); //54
        System.out.println(sum);
        int power = power(3, 6);
        System.out.println(power);
        int length = printLength("hello java");
        System.out.println(length);
        printChars("hello");
        System.out.println();
        printReverseChars("hello");
        System.out.println();
        printInBinary(32);
        System.out.println();
        int[] arr = {10,20,30,40};
        int arrSum = arrSum(arr.length, arr);
        System.out.println(arrSum);
    }

    // begin ~ end 까지 합 재귀로 구현
    public static int sum(int begin, int end){
        if (begin == end){
            return begin;
        } else {
            return end + sum(begin, end-1);
        }
    }
    // power 재귀 함수 구현
    public  static int power(int x, int n) {
        if (n == 0) {
            return 1;
        } else {
            return x * power(x, n-1);
        }
    }
    // 문자열 길이 구하는 재귀 함수
    public static int printLength(String str) {
        if (str.equals("")) return 0;
        else {
            return 1 + printLength(str.substring(1));
        }
    }
    // 문자열 프린트하는 재귀 함수
    public static void printChars(String str) {
        if (str.length() == 0) System.out.print("");
        else {
            System.out.print(str.charAt(0));
            printChars(str.substring(1));
        }
    }
    // 문자열 거꾸로 프린트하는 재귀 함수
    public static void printReverseChars(String str) {
        if (str.length() == 0) System.out.print("");
        else {
            printReverseChars(str.substring(1));
            System.out.print(str.charAt(0));
        }
    }
    // 이진수로 변환하는 메서드
    public static void printInBinary(int n) {
        if (n < 2) System.out.print(n);
        else {
            printInBinary(n / 2);
            System.out.print(n % 2);
        }
    }
    // 배열의 합
    public static int arrSum(int n, int[] arr) {
        if (n == 0) return 0;
        else {
            return arr[n-1] + arrSum(n-1, arr);
        }
    }
}
