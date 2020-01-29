package JavaStudying.InputOuput;

import java.io.*;

public class ObjectOutput {
    public static void main(String[] args) {
        objectOutput();
        objectInput();
    }

    private static void objectOutput() {
        SBox sBox1 = new SBox("Robot");
        SBox sBox2 = new SBox("Strawberry");

        try (ObjectOutputStream oo =
                new ObjectOutputStream(
                        new FileOutputStream("object.bin"))) {
            oo.writeObject(sBox1);
            oo.writeObject(sBox2);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void objectInput() {
        try (ObjectInputStream oi =
                new ObjectInputStream(new FileInputStream("object.bin"))) {

            SBox sBox1 = (SBox) oi.readObject();
            System.out.println(sBox1.getS());
            SBox sBox2 = (SBox) oi.readObject();
            System.out.println(sBox2.getS());


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
