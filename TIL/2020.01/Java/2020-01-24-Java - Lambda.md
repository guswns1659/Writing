## Lambda
- 메서드의 매개변수 타입과 이름을 지우고 사용하는 표기법이다.

## Stream
신기술은 어렵다. 배우는 과정은 힘들다. 그냥 익숙한 지식을 쓰고 싶을 뿐이다. 하지만 신기술을 배운다면 무척 유용하다. 시간도 단축되고 무엇보다 "이걸 안 배웠으면 정말 멍청했겠다"라는 반응이 나온다. 지금 Stream은 나에게 신기술이다. java라는 언어 자체가 익숙하지 않지만 Stream을 배워야 좀 더 효율적으로 사용할 수 있다.
배열이나 컬렉션에 데이터를 담고 원하는 결과를 얻기 위해선 for문이나 Iterator를 사용했지만 Stream을 통해서 간편하게 사용 가능해졌다. 배열을 Stream으로 만들고 Stream의 메서드를 사용한다.
- String은 Stream<String>으로 만들어서 사용한다.
- int[]는 IntStream으로 만들어서 사용한다.

### 스트림은 데이터 소스를 변경하지 않는다.
스트림은 데이터 소스 속 데이터를 읽기만 할 뿐 값을 변경하지 않는다.

### 스트림은 일회용이다.
- 스트림으로 데이터를 읽고 나면 닫혀서 다시 사용할 수 없다. 다시 사용하려면 한번 더 생성해야 한다.

### 생성

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
- 배열은 Stream으로 생성하려면 Arrays or Stream (IntStream, LongStream)을 이용
- IntStream의 range(), rangeClosed()는 연속된 정수를 Stream으로 만들 수 있다.

```java
public class LambdaMain {
    public static void main(String[] args) {
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

- sorted(), Comparator.reverseOrder() : 기본정력, 역순정렬

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
스트림의 요소 에 저장된 값 중에서 원하는 필드만 뽑아내거나 특정 형태로 변환해야 할 때 사용한다. 연산을 통해 스트림의 타입을 바꾸는 경우 바꾸는 타입을 지정해줘야 한다.<br>
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