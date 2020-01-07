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
- subString(1) : 앞에서부터 매개변수만큼 문자열을 자른 뒤 반환.
    - subString(str.length()-1) : 문자열의 끝 문자열 앞까지 자르고 반환.
    - charAt(str.length()-1) : 문자열의 끝 문자 반환.
- charAt(1) : 인덱스 1번 문자 반환.
- A.compareTo(B) : A와 B를 유니코드로 비교. 같으면 0, A < B 면 음수, A > B 면 양수 반환.

## HashMap
- value 전체 출력 하기 : keySet() 이용
```java
public class test {
    for (Integer key : map.keySet()){
        int value = map.get(key);
        System.out.println("value : " + value);
    }
}
```

## Math.pow(x, y)
x의 y승

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

