package index;

import java.util.ArrayList;
import java.util.Scanner;

public class index {

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        ArrayList<String> inputs = new ArrayList<>();

        System.out.println("숫자를 입력해주세요");

        while (sc.hasNextLine()) {
            String input = sc.nextLine();
            if (input == null || input.isEmpty()) {
                break;
            }
            inputs.add(input);
        }
        sc.close();

        for (int i = 0; i < inputs.size(); ++i) {
            System.out.println(inputs.get(i));
        }
    }
}