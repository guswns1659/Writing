package CSstudying.DoitCh1;

public class Exercise15to17 {
    public static void main(String[] args) {
//        triangleLB(5);
//        triangleLU(5);
        triangleRU(5);
        triangleRB(5);
    }

    private static void triangleRB(int num) {
    }

    private static void triangleRU(int num) {
        int starCount = num;
        int blankCount = num - starCount;
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= starCount; j++) {
                if (blankCount >= j) System.out.print(" ");
                else System.out.print("*");
            }
            System.out.println();
            starCount--;
        }
    }

    private static void triangleLU(int num) {
        int starCount = num;
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= starCount; j++) {
                System.out.print("*");
            }
            System.out.println();
            starCount--;
        }
    }

    private static void triangleLB(int num) {
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
