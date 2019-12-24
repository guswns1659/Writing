package index;

public class Algorithm {
    public static void main(String[] args) {
        System.out.println(printLength("Hello"));
        printChars("Hello");
        printReverseChars("Hello");
        printInBinary(15);
        int[] arr = {1,2,3,4};
        System.out.println(calcArrSum(4, arr));
    }

    // 문자열의 길이 구하는 재귀 함수

    private static int printLength(String str) {
        if (str.equals("")) return 0;
        else {
            return 1 + printLength(str.substring(1));
        }
    }

    // 문자열 프린트 재귀 함수
    // 1. 길이가 0이면 함수 종료
    // 2. 길이 != 0 이면 앞 글자 프린트 한 뒤 앞 글자뺀 문자열을 매개변수로 재귀함수 호출

    public static void printChars(String str) {
        if (str.length() == 0) return;
        else {
            System.out.print(str.charAt(0));
            printChars(str.substring(1));
        }
    }
    // 문자열 뒤집어 프린트
    private static void printReverseChars(String str) {
        if (str.length() == 0) return;
        else {
            printReverseChars(str.substring(1));
            System.out.print(str.charAt(0));
        }
    }

    // 2진수 변환 재귀 함수
    /* 1. n < 2 면 n을 출력
       2. n을 2진수로 표현하려면 (n / 2)를 이진수로 + (n % 2)출력
    */
    public static void printInBinary(int n) {
        if (n < 2) System.out.print(n);
        else {
            printInBinary(n / 2);
            System.out.print(n % 2);
        }
    }

    // 배열의 합 재귀함수
    public static int calcArrSum(int n, int[] arr){
        if (n <= 0) return 0;
        else {
            return arr[n-1] + calcArrSum(n-1, arr);
        }
    }
}