package JavaStudying;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaMain {
    public static void main(String[] args) {
        String[] names = {
                "jun", "jack", "poogle", "jason",
                "hidee", "crong", "honux", "JK"
        };

        Stream<String> namesStream = Stream.of(names);

        ArrayList<String> arrayListNames =
                namesStream.collect(Collectors.toCollection(ArrayList::new));
        arrayListNames.add("jun");
        for (String name : arrayListNames) {
            System.out.println(name);
        }
    }
}
