package index;

public class index {
    public static void main(String[] args) {
        int result = sum(4);
        System.out.println(result);
        int result2 = factorial(4);
        System.out.println(result2);
        int result3 = fibonacci(4);
        System.out.println(result3);
        int result4 = power(4, 3);
        System.out.println(result4);

    }
    // 0 ~ n까지 합을 구하는 재귀 함수
    public static int sum(int n) {
        if (n == 0) return 0;
        else return n + sum(n-1);
    }
    // 1 ~ n까지 곱을 구하는 재귀 함수
    public static int factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n*factorial(n-1);
        }
    }
    // 피보나치 수열 구하는 재귀 함수
    public static int fibonacci(int n) {
        if (n < 2) {
            return n;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
    // 제곱의 값을 구하는 재귀 함수
    public static int power(int x, int n) {
        if (n == 0) {
            return 1;
        } else {
            return x * power(x, n-1);
        }
    }
}