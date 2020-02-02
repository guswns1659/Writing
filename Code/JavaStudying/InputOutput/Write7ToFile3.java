package JavaStudying.InputOutput;

import java.io.*;

public class Write7ToFile3 {
    public static void main(String[] args) {
        output();
        input();
    }

    private static void output() {
        try (OutputStream out = new FileOutputStream("data.dat")) {
            out.write(7);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void input() {
        try (InputStream in = new FileInputStream("data.dat")) {
            int dat = in.read();
            System.out.println(dat);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
