package JavaStudying.InputOutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class TextReader {
    public static void main(String[] args) {
        textReader();
    }

    private static void textReader() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("읽을 파일 : ");
        String source = scanner.nextLine();

        try (BufferedReader in =
                     new BufferedReader(new FileReader(source))) {
            String ch;
            while (true) {
                ch = in.readLine();
                if (ch == null) {
                    break;
                }
                System.out.println(ch);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
