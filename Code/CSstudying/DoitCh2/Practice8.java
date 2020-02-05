package CSstudying.DoitCh2;

public class Practice8 {
    private char[] numbers;

    public Practice8() {
        numbers = new char[32];
    }

    public static void main(String[] args) {
        // number를 입력한 radix로 바꿔서 출력
        Practice8 practice8 = new Practice8();

        int digits = getDigitsFromRadixConvert(100, 8, practice8.numbers);
        print(digits, practice8.numbers);

    }

    private static void print(int digits, char[] numbers) {
        for (int i = digits - 1; i >= 0; i--) {
            System.out.print(numbers[i]);
        }
    }

    private static int getDigitsFromRadixConvert(int number, int radix, char[] numbers) {
        int digits = 0;
        String numberChars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        while (number != 0) {
            numbers[digits++] = numberChars.charAt(number % radix);
            number /= radix;
        }
        return digits;
    }
}
