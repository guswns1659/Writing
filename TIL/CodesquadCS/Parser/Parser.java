package CodesquadCS.Parser;

import java.util.*;

public class Parser {

    public String tokenizer(String inputString) {
        return inputString.replaceAll(",", " ").replaceAll("  ", " ")
                .replaceAll("\\[", "[ ").replaceAll("\\]", " ]");
    }

    public Map<String, Object> makeSolidMap(int number) {
        Map<String, Object> result = new HashMap<>();

        result.put("value", number);
        result.put("type", "number");

        return result;
    }

    List<Object> ArrayParser(String inputString) {
        // 1. input 배열을 tokenize 후 foreach 로 돌려준다
        // 2.
        // - [ 면 add
        // - 숫자면 intvalue 에 임시저장
        //      - 다음이 숫자면 *10 해서 더한다.
        //      - 빈칸이면 add
        // - ] 만나면 [ 만날떄까지 pop 한다.
        //      - 숫자가 나오면 int 넣기
        //      - [ 만나면 break;

        String tokenizeString = tokenizer(inputString);
        Stack<String> tokenStack = new Stack<String>();
        int intValue = 0;
        List<Object> resultList = new LinkedList<Object>();

        System.out.println(tokenizeString);
        for (int i = 0; i < tokenizeString.length(); i++) {
            if (tokenizeString.charAt(i) == '[') {
                tokenStack.add(tokenizeString.charAt(i) + "");
            } else if (tokenizeString.charAt(i) > '0' && tokenizeString.charAt(i) < '9') {
                if (intValue != 0) {
                    intValue *= 10;
                }
                intValue += tokenizeString.charAt(i) - '0';

                if (tokenizeString.charAt(i + 1) == ' ') {
                    tokenStack.add(intValue + "");
                    intValue = 0;
                }
            } else if (tokenizeString.charAt(i) == ']') {
                while (!tokenStack.peek().equals("[")) {
                    resultList.add(makeSolidMap(Integer.parseInt(tokenStack.pop())));
                }
                tokenStack.pop();
            }
        }

        return resultList;
    }

}