package JavaStudying.Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamClass2 {
    public static void main(String[] args) {
        flatMapTest();
    }

    private static void flatMapTest() {
        // parallel(), collect(), filter()
        List<String> list = Arrays.asList("Hello", "box", "robot", "toy");
        List<String> list2 = list.parallelStream()
                .filter(s -> s.length() < 5)
                .collect(() -> new ArrayList<>()
                        , (c, s) -> c.add(s)
                        , (lit1, lit2) -> lit1.addAll(lit2));

        for (String each : list2) System.out.println(each);
    }
}
