package JavaStudying.InputOutput;

import java.io.*;
import java.util.Scanner;

public class StringWriter {
    public static void main(String[] args) {
        stringWriter();
        stringReader();
    }

    private static void stringReader() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("읽을 파일 : ");
        String source = scanner.nextLine();

        try (BufferedReader br =
                     new BufferedReader(new FileReader(source))) {
            String line;
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void stringWriter() {
        String string1 = "공부에 있어서 돈이 꼭 필요한 것은 아니다.";
        String string2 = "Life is long if you know how to use it.";

        try (BufferedWriter br =
                     new BufferedWriter(new FileWriter("data.md"))) {
            br.write(string1, 0, string1.length());
            br.newLine();
            br.write(string2, 0, string1.length());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
