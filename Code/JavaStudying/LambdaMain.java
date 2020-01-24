package JavaStudying;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaMain {
    public static void main(String[] args) {
        // map()
        Stream<File> fileStream
                = Stream.of(new File("Ex1.java"), new File("Ex1"), new File("Ex1.txt"), new File("Ex2.java"));
        Stream<String> filenameStream = fileStream.map(File::getName);
        filenameStream.forEach(System.out::println);

        Stream<File> fileStream2
                = Stream.of(new File("Ex1.java"), new File("Ex1"), new File("Ex1.txt"), new File("Ex2.java"));
        fileStream2.map(File::getName)
                .filter(str -> str.indexOf(".") != -1)
                .map(str -> str.substring(str.indexOf(".")+1))
                .map(String::toUpperCase)
                .distinct()
                .forEach(System.out::println);
    }
}
