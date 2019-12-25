package index;

public class index {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        sum(a, b); // 30
        System.out.println(a); // 10

        int[] arr = new int[2];
        arr[0] = 10;
        arr[1] = 20;
        arrSum(arr);
        System.out.println(arr[0]); // 20
    }
    public static void sum(int a, int b) {
        System.out.println(a + b);
        a = 40;
    }
    public static void arrSum(int[] arr) {
        System.out.println(arr[0] + arr[1]);
        arr[0] = 20;
    }
}
