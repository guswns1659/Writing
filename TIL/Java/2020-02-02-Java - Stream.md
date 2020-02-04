## Stream
신기술은 어렵다. 배우는 과정은 힘들다. 그냥 익숙한 지식을 쓰고 싶을 뿐이다. 하지만 신기술을 배운다면 무척 유용하다. 시간도 단축되고 무엇보다 "이걸 안 배웠으면 정말 멍청했겠다"라는 반응이 나온다. 지금 Stream은 나에게 신기술이다. java라는 언어 자체가 익숙하지 않지만 Stream을 배워야 좀 더 효율적으로 사용할 수 있다.
배열이나 컬렉션에 데이터를 담고 원하는 결과를 얻기 위해선 for문이나 Iterator를 사용했지만 Stream을 통해서 간편하게 사용 가능해졌다. 배열을 Stream으로 만들고 Stream의 메서드를 사용한다.

## 스트림의 필요성
우리가 콜렉션 인스턴스를 만들면 보통 그 안에 데이터를 사용하기 위함이다. 예를 들어, ArrayList에 1~10까지 숫자가 있을 때, 홀수만 꺼내서 합을 구하려면 보통 for문을 쓴다.
그런데, 매번 이런 작업이 불편하다고 느낀 전문가들이 편하게 콜렉션을 사용할 수 없을까? 해서 만든게 stream이다.<br>
컬렉션의 데이터를 스트림이라는 객체의 인스턴스로 만들어서 파이프를 통과해서 결과값을 얻을 수 있게 도와준다.
[https://player.vimeo.com/video/242189290](https://player.vimeo.com/video/242189290)

### 스트림의 특성
- 스트림은 데이터 소스 속 데이터를 읽어서 스트림 인스턴스를 만들 뿐이지 값을 변경하지 않는다.
- 스트림으로 데이터를 읽고 나면 닫혀서 다시 사용할 수 없다. 다시 사용하려면 한번 더 생성해야 한다.

### 스트림의 중간연산과 최종연산
스트림 인스턴스를 만들어 각 연산을 하는 파이프(연산)에 통과시킬 때 맨 마지막에 오는 파이프를 최종연산이라 한다. 그 앞에 오는 모든 연산을 중간연산이라 한다. 최종 연산인 이유는 스트림 인스턴스의 값을 연산한 뒤 스트림을 닫아버리기 때문이다. ex) sum, max, min 등이다.<br>
중간 연산은 스트림을 닫지 않는다. 그대로 유지시켜서 다른 파이프에 통과시킬 수 있다.

### 스트림의 연산을 연속해서 할 수 있는 이유
스트림을 생성하면 참조 변수가 생기는데, 모든 메서드가 같은 참조변수로 활용하기 때문이다.

### 생성
- 배열은 Arrays.stream()으로 생성한다.
- 컬렉션 인스턴스는 stream()이 컬렉션의 디폴트 메서드이기에 메서드로 사용하면 된다. ex) list.stream();
- Stream.of(가변인자)는 위 2가지 방법과는 차이가 있다. 기존에 존재하지 않는 데이터로 바로 스트림을 만들 수 있다. 또한 만약 of()의 인자로 컬렉션 인스턴스가 오면 그 인스턴스가 들어간 스트림이 만들어진다. 컬렉션 속 데이터가 담기는 것이 아니다. 배열은 상관없다.

#### concat
Stream.concat(stream1, stream2)를 통해서 두 개의 스트림을 하나로 합칠 수 있다.

#### 컬렉션(List, Set)

```java
public class LambdaMain {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        Stream<Integer> intStream = list.stream();
        intStream.forEach((num) -> System.out.println(num));
        intStream.forEach((num) -> System.out.println(num)); // 한번 사용 후 재사용 불가.
    }
}
```

#### 배열
- 배열은 Stream으로 생성하려면 Arrays.stream() 이용
- IntStream.stream(int[] array, int startInclusive, int endExclusive)
- IntStream의 range(), rangeClosed()는 연속된 정수를 Stream으로 만들 수 있다.

```java
public class LambdaMain {
    public static void main(String[] args) {
        
        // 인덱스 지정해서 스트림 만들 수 있다. 
        int[] intArr = {1, 2, 3, 4, 5};
        Arrays.stream(intArr, 0, 3)
                .forEach(System.out::println);
    
        String[] strArr = {"a", "b", "c"};
        Stream<String> Stream1 = Stream.of(strArr);
        Stream<String> Stream2 = Stream.of("a", "b", "d"); // 가변인자
        Stream<String> Stream3 = Arrays.stream(strArr);

        Stream1.forEach(System.out::println);
        Stream2.forEach(System.out::println);

        IntStream intStream1 = IntStream.of(1, 2, 3);
        IntStream intStream2 = IntStream.range(1, 100); // 1 ~ 99
        IntStream intStream3 = IntStream.rangeClosed(1, 100); // 1 ~ 100

        intStream2.forEach(System.out::println);
    }
}
```

#### 람다식 - iterate(), generate() : 무한 스트림 생성

```java
public class LambdaMain {
    public static void main(String[] args) {
        Stream<Integer> evenStream = Stream.iterate(0, n -> n+2);
        Stream<Double> randomStream = Stream.generate(Math::random);
        randomStream.forEach(System.out::println);
    }
}
```

#### 스트림의 중간연산
- skip(), limit() : 입력된 개수에 맞게 skip 하거나 limit으로 뽑음

```java
public class LambdaMain {
    public static void main(String[] args) {
        // skip(), limit()
        IntStream intStream = IntStream.range(1,10);
        intStream.skip(4).limit(3).forEach(System.out::print); // 5, 6, 7
    }
}
```

- filter(), distinct() : filter는 조건에 맞는 애들만 남긴다. distinct는 중복을 제거한다.

```java
public class LambdaMain {
    public static void main(String[] args) {
        // filter(), distinct()
        IntStream intStream2 = IntStream.of(1,1,2,2,3,4,5,6,7,7,8,8);
        intStream2.distinct().forEach(System.out::println);
        IntStream intStream3 = IntStream.of(1,1,2,2,3,4,5,6,7,7,8,8);
        intStream3.filter(i -> i % 2 ==0).forEach(System.out::println);
    }
}
```

- sorted(), Comparator.reverseOrder() : 기본정렬, 역순정렬

```java
public class LambdaMain {
    public static void main(String[] args) {
        //sorted(), Comparator.reverseOrder()
        Stream<String> strStream = Stream.of("a", "b", "CC", "ADF");
        strStream.sorted().forEach(System.out::println);
        Stream<String> strStream2 = Stream.of("a", "b", "CC", "ADF");
        strStream2.sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }
}

```

- map()
스트림의 요소 에 저장된 값 중에서 원하는 필드만 뽑아내거나 **특정 형태로 변환해야 할 때** 사용한다. 연산을 통해 스트림의 타입을 바꾸는 경우 바꾸는 타입을 지정해줘야 한다.<br>
filter()는 람다식 조건에 맞는 애들만 남기지만 map()은 실제로 연산을 해서 Stream 내 데이터를 변경하기도 한다.

```java
public class LambdaMain {
    public static void main(String[] args) {
        // map()
        Stream<File> fileStream
                = Stream.of(new File("Ex1.java"), new File("Ex1"), new File("Ex1.txt"), new File("Ex2.java"));
        Stream<String> filenameStream = fileStream.map(File::getName);
        filenameStream.forEach(System.out::println);
        
        // 파일의 확장자만 뽑은 다음 중복을 제거해서 출력하는 코드
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
```

- mapToInt(), mapToLong(), mapToDouble()
map()을 사용하면 들어오는 값과 나오는 값의 타입이 모두 제네릭이기 때문에 만약 int라면 integer로 boxing이 된다. 이를 피하기 위해선 mapToInt()를 사용하면 바로 int형(정확히는 IntStream)이 반환된다.
- flatMap() : map()은 1:1로 매핑되지만 flatMap()은 1 : *로 매핑된다. 리턴값이 스트림이다. 예를들어, 하나의 단어가 입력으로 들어가서 split되서 결과로 2개의 단어가 담긴 스트림이 나올 수 있다. 안에서 자동으로 concat()을 한다.

```java
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
```

- peek() : foreach처럼 데이터 하나에 연산을 할 수 있지만 중간연산이기에 최종 연산이 있어야 활용 가능하다.



#### Optional<T>와 OptionalInt
Optional<T>는 지네릭 클래스로 "T타입의 객체"를 감싸는 래퍼 클래스이다. 그래서 Optional타입의 객체에는 모든 타입의 참조변수를 담을 수 있다.
최종 연산의 결과를 그냥 반환하는 것이 아니라 Optional객체에 담아서 반환하는 것이다. 이처럼 객체에 담아서 반환을 하면, 반환된 결과가 null인지 매번 if문으로 체크하는 대신 Optional에 정의된 메서드를 통해서 간단히 처리할 수 있다.

```java
public class LambdaMain {
    public static void main(String[] args) {
        Optional<String> optStr = Optional.of("abcde");
        Optional<Integer> optInt = optStr.map(String::length);

        System.out.println(optStr.get());
        System.out.println(optInt.get());

        int result = Optional.of("123")
                .filter(num -> num.length() > 0)
                .map(Integer::parseInt)
                .get();

        // orElse(-1) : 결과값이 null이라면 -1를 반환한다.
        int result2 = Optional.of("")
                .filter(num -> num.length() > 0)
                .map(Integer::parseInt)
                .orElse(-1);

        System.out.println(result);
        System.out.println(result2);
    }
}

```



#### 스트림의 최종 연산

- allMatch(), anyMatch(), noneMatch(), findFirst(), findAny()
메서드의 이름이 어떤 일을 하는 지 알려준다. 람다식 조건에 따라 결과를 반환한다. allMatch()는 조건에 모두 참이니?, anyMatch()는 조건에 하나라도 만족하니?, noneMatch()는 조건 모두가 false니?

```java
public class LambdaMain {
    public static void main(String[] args) {
        String[] strArr = {
                "Inheritance", "Java", "Lambda", "stream",
                "OptionalDouble", "IntStream", "count", "sum"
        };
        Stream.of(strArr).forEach(System.out::println);

        boolean noEmptyStr = Stream.of(strArr).noneMatch(s -> s.length() == 0);

        Optional<String> sWord = Stream.of(strArr).filter(s -> s.charAt(0) == 's').findFirst();

        System.out.println(noEmptyStr);
        System.out.println(sWord.get());
    }
}

```

- reduce()
여러개의 데이터를 연산을 통해 1개의 값으로 줄인다. 대표적으로 sum()이 있다. reduce()는 데이터를 줄이는 연산을 내가 정할 수 있다. reduce()의 첫 번째 인자는 스트림의 0번째 인덱스로 들어가서 연산을 적용받는다. 스트림이 비었을 경우 첫 번째 인자가 반환되지만 값을 처리할 땐 주의해야 한다.

```java
public class LambdaMain {
    public static void main(String[] args) {
        String[] strArr = {
                "Inheritance", "Java", "Lambda", "stream",
                "OptionalDouble", "IntStream", "count", "sum"
        };

        IntStream intStream1 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream2 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream3 = Stream.of(strArr).mapToInt(String::length);
        IntStream intStream4 = Stream.of(strArr).mapToInt(String::length);

        int count = intStream1.reduce(0, (a, b)-> a + 1);
        int sum = intStream2.reduce(0, (a,b) -> a+b);

        OptionalInt max = intStream3.reduce(Integer::max);
        OptionalInt min = intStream4.reduce(Integer::min);

        System.out.println(count);
        System.out.println(sum);
        System.out.println(max.getAsInt());
        System.out.println(min.getAsInt());
    }
}

```

- sum(), count(), average(), max(), min()
최종 연산 중 대표적인 연산들이다. 이름에서 메서드가 무슨 일을 하는 지 명확하게 파악이 된다. 그런데 average(), max(), min()의 반환 값은 Optional형태이다. 값이 감싸져서 나오는다. 복잡해 보이지만 Optional의 ifPresent() 같은 메서드를 유용하게 사용할 수 있다.

#### 병렬스트림
병렬처리는 하나의 일을 나눠서 처리하는 것을 의미한다. 항상 병렬처리가 빠른 것은 아니다. 병렬처리를 하기 위해 일을 나누고 병렬처리 후에 일을 취합하는 과정이 생각보다 복잡하다. 그런데 자바에서 이젠 병렬처리를 할 수 있는 병렬 스트림을 지원한다.

```java
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
```


#### collect()
스트림의 요소를 수집하는 최종 연산이다. 우리는 스트림을 사용하고 연산된 값을 가지고 싶을 때가 있다. 그럴 때 collect()가 도와준다. 스트림은 한번 사용하면 다시 사용할 수 없기 때문에 collect()의 기능은 중요하다.

- 스트림을 컬렉션과 배열로 변환 : toList(), toSet(), toMap(), toCollection(), toArray()

```java
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
```

- 병렬 스트림에서의 collect
병렬 스트림에서는 어떻게 collect가 작동할까???

```java
public class StreamClass2 {
    public static void main(String[] args) {
        flatMapTest();
    }

    private static void flatMapTest() {
        // parallel(), collect(), filter()
        List<String> list = Arrays.asList("Hello", "box", "robot", "toy");
        List<String> list2 = list.parallelStream()
                .filter( s-> s.length() < 5)
                .collect(() -> new ArrayList<>()
                        ,(c, s) -> c.add(s)
                        ,(lit1, lit2) -> lit1.addAll(lit2));

        for (String each : list2) System.out.println(each);
    }
}
```