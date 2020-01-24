package TPC1;

public class TPC50 {
    public static void main(String[] args) {
        // int -> String
        int i = 30;
        int j = 40;
        String a = String.valueOf(30);
        String b = String.valueOf(40);
        System.out.println(a+b);

        // String -> int
        String str = "100";
        String str2 = "200";
        int c = Integer.parseInt(str, 16);
        int d = Integer.parseInt(str2);
        System.out.println(c);
    }
}
