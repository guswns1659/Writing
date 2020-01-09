package CodesquadCS.Algorithm;

public class ReverseInteger {
    public int reverse(int number) {
        int absNumber = Math.abs(number);
        int answer = calculate(absNumber);
        if (number < 0) {
            answer = answer * -1;
        }
        return answer;
    }

    public int calculate(int number) {
        String answerStr = "";
        String num2str = Integer.toString(number);
        final int REPEAT_NUM = num2str.length();

        for (int count = 0; count < REPEAT_NUM; count++) {
            String last = String.valueOf(num2str.charAt(num2str.length()-1));
            num2str = num2str.substring(0, num2str.length()-1);
            if (last.equals("0") && answerStr.length() == 0) {
                continue;
            } else {
                answerStr += last;
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