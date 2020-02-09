package JavaStudying.Lambda;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaMain {
    public static void main(String[] args) {
        printTest(s -> System.out.println(s));
    }

    private static void printTest(Printable printable) {
        printable.print("string");
    }
}

interface printable {
    void print(String string);
}


