package CodesquadCS.Algorithm;

public class ReverseInteger {
    public int reverse(int number) {
        boolean isNegative = false;
        if (number < 0) {
            isNegative = !isNegative;
            number = Math.abs(number);
        }
        int answer = reverse2(number);
        if (isNegative) {
            answer = answer * -1;
        }
        return answer;
    }
    public int reverse2 (int number) {
        String answerStr = "";
        String num2str = Integer.toString(number);
        final int REPEAT_NUM = num2str.length();
        final int STR_LENGTH = num2str.length();

        for (int i = 0; i < REPEAT_NUM; i++) {
            String lastStr = String.valueOf(num2str.charAt(STR_LENGTH-1));
            num2str = num2str.substring(0, STR_LENGTH-1);
            if (lastStr.equals("0") && answerStr.length() == 0) {
                continue;
            } else {
                answerStr += lastStr;
            }
        }

        if (number == 0) {
            return number;
        }

        try {
            int answer = Integer.parseInt(answerStr);
            return answer;
        } catch (Exception e) {
            return 0;
        }
    }
}