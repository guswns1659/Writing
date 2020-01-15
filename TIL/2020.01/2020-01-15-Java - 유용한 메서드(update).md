## 형변환
- int -> String : Integer.toString();
- String -> int : String.valueOf(); , Integer.toString();
- Double -> int : (int)
- int -> Double : (Double)
- 진법 변환 : Integer.parseInt("100", 16); -> 16진수 100을 계산해봐 : 16^2

## 자료형 확인
객체 자료형에서 사용 가능하다.
- str instanceof String : return값은 true or false
- str.getClass() : return 값은 class java.lang.String

## Array 초기화 방법
1. for문 사용
2. Arrays.fill(arr, 3) : 같은 값으로 초기화
3. int[] arr = {1, 2, 3, 4, 5} : 선언할 때 초기화
4. forEach문

```java
public class test{
    int[] arr = new int[7];
            Arrays.fill(arr, 3);
            for(int i=0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
    
    int[] days = {1,2,3,4,5,6,7,8,9,10,11,12};
}

```
## String 메서드
- subString(1) : 인덱스 1부터 끝까지 잘라서 반환.
    - subString(str.length()-1) : 문자열의 끝 문자열 앞까지 자르고 반환.
    - charAt(str.length()-1) : 문자열의 끝 문자 반환.
- charAt(1) : 인덱스 1번 문자 반환.
- A.compareTo(B) : A와 B를 유니코드로 비교. 같으면 0, A < B 면 음수, A > B 면 양수 반환.

## Hash
### 1. HashMap
- value 전체 출력 하기 : keySet() 이용
- getOrDefault(key, default) : 값이 있으면 가져오고 없다면 정해진 Default를 넣는다.
```java
public class test {
    for (Integer key : map.keySet()){
        int value = map.get(key);
        System.out.println("value : " + value);
    }
}
```

### 2. HashSet : 배열 속 중복된 값을 줄이는 클래스 
- hashset contains unique elements only.
```java
import java.util.ArrayList;import java.util.HashSet;
public class test {
    String[] arr = {"a", "b", "c"};
    ArrayList<Integer> arr = new ArrayList<>(new HashSet<>(arr));
}
```
## Math 
- Math.pow(x, y) : x의 y승
- Math.sqrt() : 제곱근

## 랜덤으로 문자열 출력하는 코드 
### 1. Random의 nextInt() 
- nextInt()는 int 범위 내 랜덤으로 숫자를 출력한다. 
- nextInt(int num)은 0 ~ num-1 사이 숫자를 랜덤으로 출력한다. 

### 2. StringBuilder 
- 문자열 추가 및 삽입할 때 사용하는 객체이다. += 대신에 append or insert를 사용하면 된다. 
```java
public class test {
    public String randomId() {
        String id = "";
        for (int i = 0; i < 4; i++) {
            Random rnd = new Random();
            String randomStr = String.valueOf((char) ((rnd.nextInt(26)) + 97));
            id += randomStr;
        }
        return id;
    }
}
```

## 배열 속 원소를 비교할 때 
- Arrays로 sort하고 반복문 돌면서 각 원소를 equals()로 비교한다. 

## List
- List의 경우 그냥 System.out.println을 해도 배열 값이 출력된다.

## replaceAll()
- java replaceAll()은 정규표현식 사용 가능. [] 안에 값을 넣는다. 
- Collectors.joining() : 배열의 원소를 하나로 합쳐준다. 
- joining(delimeter) : 문자 사이에 delimeter 넣고 합쳐준다.
- joining(delimeter, prefix, surfix) : 문자 사이에 delimeter 넣고 맨 앞에는 prefix, 뒤에는 suffix를 합쳐준다.

## String[]을 int[]로 한번에 바꾸는 메서드
- Arrays.stream(splitCoordinates).mapToInt(Integer::parseInt).toArray();

## 기본 배열을 자르는 코드 
- int[] slicedArr = Arrays.copyOfRange(array, startIndex, endIndex + 1); 