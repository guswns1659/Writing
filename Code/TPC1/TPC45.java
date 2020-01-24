package TPC1;

import java.util.Scanner;

public class TPC45 {
    public static void main(java.lang.String[] args) {
        // 1. heap area에 만들어지는 String
        String str1 = "hello";
        String str2 = "hello";

        if (str1.equals(str2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        // 2. literal pool에 만들어지는 String
        String str3 = "hello";
        String str4 = "hello";

        if (str3 == str4) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        // 3. scanner로 입력 받은 문자열은 heap area에 생성된다.
        Scanner s = new Scanner(System.in);
        java.lang.String str5 = s.nextLine();
        java.lang.String str6 = s.nextLine();
        if (str5 == str6) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
