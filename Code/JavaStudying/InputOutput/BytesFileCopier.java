package JavaStudying.InputOutput;

import java.io.*;
import java.util.Scanner;

public class BytesFileCopier {
    public static void main(String[] args) {
        copyPaste();
    }

    private static void copyPaste() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("원본 파일 : ");
        String source = scanner.nextLine();

        System.out.print("복사 파일 : ");
        String destination = scanner.nextLine();

        try (InputStream in = new FileInputStream(source);
             OutputStream out = new FileOutputStream(destination)) {
            byte[] buf = new byte[1024];
            int len;

            while (true) {
                len = in.read(buf);
                if (len == -1) {
                    break;
                }
                out.write(buf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
