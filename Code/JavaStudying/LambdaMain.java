package JavaStudying;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaMain {
    public static void main(String[] args) {
        // flatMap() : Stream<String[]>을 Stream<String>으로 만들 때
        Stream<String[]> stream
                = Stream.of(new String[]{"a","b","c"},
                new String[]{"d","e","f"});
        Stream<String> strStream = stream.flatMap(Arrays::stream);
        strStream.forEach(System.out::println);

        // 문장을 단어로 쪼개 Stream에 넣는 코드
        String[] lineArr = {
                "Belive or not It is true",
                "Do or do not There is no try"
        };
        Stream<String> lineStream = Stream.of(lineArr);
        Stream<String> strStream2 = lineStream
                .flatMap(line -> Stream.of(line.split(" ")));
        strStream2.forEach(System.out::println);
    }
}
