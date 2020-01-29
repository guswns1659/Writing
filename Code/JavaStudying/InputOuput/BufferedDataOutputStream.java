package JavaStudying.InputOuput;

import java.io.*;

public class BufferedDataOutputStream {
    public static void main(String[] args) {
        bufferedOutput();
        bufferedInput();
    }

    private static void bufferedOutput() {
        try(DataOutputStream out
                    = new DataOutputStream(
                            new BufferedOutputStream(
                                    new FileOutputStream("data.md")))){
            out.writeInt(123);
            out.writeDouble(123.123);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void bufferedInput() {
        try (DataInputStream in =
                new DataInputStream(
                        new BufferedInputStream(
                                new FileInputStream("data.md")))) {
            System.out.println(in.readInt());
            System.out.println(in.readDouble());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
