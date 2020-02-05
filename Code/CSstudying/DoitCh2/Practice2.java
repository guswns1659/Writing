package CSstudying.DoitCh2;

import java.util.Arrays;

public class Practice2 {
    public static void main(String[] args) {
        int[] intArr = {10, 30, 40, 50, 60};
        reverse(intArr);
        int sum = Arrays.stream(intArr)
                .sum();
        System.out.println(sum);
    }

    private static void reverse(int[] intArr) {
        for (int i = 0; i < intArr.length / 2; i++) {
            swap(intArr, i, intArr.length - i - 1);
        }
    }

    private static void swap(int[] intArr, int index1, int index2) {
        int tmp = intArr[index1];
        intArr[index1] = intArr[index2];
        intArr[index2] = tmp;
    }
}
