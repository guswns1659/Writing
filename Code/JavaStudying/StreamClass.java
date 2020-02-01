package JavaStudying;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.IntStream;

public class StreamClass {
    private static StreamClass streamClass;

    public static void main(String[] args) {
        streamClass.intStreamSumTest();
    }

    public void intStreamSumTest() {
        int[] arr = {1,2,3,4,5};
        IntStream intStream1 = Arrays.stream(arr);
        IntStream intStream2 = intStream1.filter( n -> n % 2 == 1);
        int sum = intStream2.sum();
        System.out.println(sum);
    }

    public void stringStream() {
        List<String> strList = Arrays.asList("a", "b", "c");
        strList
        .forEach(System.out::println);
    }

    public void splitedIntStream() {
        int[] intArr = {1, 2, 3, 4, 5};
        Arrays.stream(intArr, 0, 3)
                .forEach(System.out::println);
    }
}

class ToyPriceInfo {
    private String model;
    private int price;

    public ToyPriceInfo(String model, int price) {
        this.model = model;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
class ToyMain {
    public int getToyPriceUnder500() {
        List<ToyPriceInfo> toyList = new ArrayList<>();
        toyList.add(new ToyPriceInfo("a", 200));
        toyList.add(new ToyPriceInfo("b", 350));
        toyList.add(new ToyPriceInfo("c", 550));
        int sum = toyList.stream()
                .filter(t -> t.getPrice() < 500)
                .mapToInt(ToyPriceInfo::getPrice)
                .sum();
        return sum;
    }
}

class ReduceMain {
    public String getMaxLengthString() {
        List<String> strArr = Arrays.asList("Box","Simple","Complex","Robot");

        BinaryOperator<String> lc = (s1, s2) -> {
            if (s1.length() > s2.length()) return s1;
            else return s2;
        };

        String result = strArr.parallelStream()
                .reduce("", lc);
        return result;
    }
}
