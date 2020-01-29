package JavaStudying.InputOuput;

import java.io.*;

public class DataFilterOuputStream {
    public static void main(String[] args) {
        outputFilterStream();
        inputFilterStream();
    }

    private static void outputFilterStream() {
        try(DataOutputStream out
                    = new DataOutputStream(new FileOutputStream("data.md"))){
            out.writeInt(370);
            out.writeDouble(370.123);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void inputFilterStream() {
        try(DataInputStream in
                    = new DataInputStream(new FileInputStream("data.md"))){
            int num = in.readInt();
            double num2 = in.readDouble();

            System.out.println(num);
            System.out.println(num2);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
