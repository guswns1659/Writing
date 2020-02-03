package CSstudying.DoitCh1;

import java.util.Scanner;

public class Practice1to3 {
    public static void main(String[] args) {
        System.out.println(max4());
        System.out.println(min4());
    }

    private static int min4() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("4개의 값 중 최솟값을 구하는 메서드입니다.");

        System.out.print("num1를 입력해주세요");
        int num1 = scanner.nextInt();
        System.out.print("num2를 입력해주세요");
        int num2 = scanner.nextInt();
        System.out.print("num3를 입력해주세요");
        int num3 = scanner.nextInt();
        System.out.print("num4를 입력해주세요");
        int num4 = scanner.nextInt();

        int min = num1;
        if (num2 < min) min = num2;
        if (num3 < min) min = num3;
        if (num4 < min) min = num4;
        return min;

    }


    private static int max4() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("3개의 값 중 최댓값을 구하는 메서드입니다.");

        System.out.print("num1를 입력해주세요");
        int num1 = scanner.nextInt();
        System.out.print("num2를 입력해주세요");
        int num2 = scanner.nextInt();
        System.out.print("num3를 입력해주세요");
        int num3 = scanner.nextInt();

        int max = num1;
        if (num2 > max) max = num2;
        if (num3 > max) max = num3;
        return max;
    }


}
