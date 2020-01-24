package JavaStudying;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaMain {
    public static void main(String[] args) {
        int[] strArr = {1, 2, 3};

        Arrays.stream(strArr).forEach((str) -> System.out.println(str));

    }
}
