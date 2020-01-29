package JavaStudying.InputOuput;

import java.io.*;

public class SimpleWriter {
    public static void main(String[] args) {
        simpleWriter();
        simpleReader();
    }

    private static void simpleReader() {
        try(Reader in = new FileReader("data.md")) {
            System.out.println(in.read());
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void simpleWriter() {
        try(Writer out = new FileWriter("data.md")) {
            out.write("abc");
            out.write("def");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
