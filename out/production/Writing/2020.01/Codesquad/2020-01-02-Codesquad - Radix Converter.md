## 목차
- 논리게이트
- 이진수 덧셈기
- 진수 변환기

## 핵심
- **컴퓨터는 전기 신호를 0과 1로 인식해 모든 수를 표현한다.**
## 논리게이트
- AND 게이트
AND는 모든 bit가 true일 때 true로 반환한다. 아닐 시 모두 false
- OR 게이트
OR는 하나의 bit라도 true일 때 true로 반환한다.
- INVERTOR
true가 입력되면 false가 출력되고, false가 입력되면 true가 출력된다.
- NAND 게이트
AND 게이트의 반대이다. 약간 헷갈린데, 예시를 들자면 버튼 2개를 모두 눌렀을 때 불이 꺼진다. 아니라면 모두 켜진다.
    - 0 0 -  1
    - 1 0 -  1
    - 0 1 -  1
    - 1 1 -  0
- NOR 게이트
OR 게이트의 반대이다.
    - 0 0 - 1
    - 1 0 - 0
    - 0 1 - 0
    - 1 1 - 0

## 이진수 덧셈기
- 반 덧셈기(Half - adder)
반가산기는 반 쪽짜리 가산기이다. 2개의 비트만 덧셈이 가능하다. 왜냐하면 그 이상 자리수에서는 자리 변환수(carry)를 인자로 받을 수 없기 때문이다.
- 전체 덧셈기(Full - adder)
전체 덧셈기는 비트가 2개 이상인 값들의 연산이 가능하다. 왜냐하면 자리 변환수(carry)를 인자로 받을 수 있기 때문이다.

## 진수 변환기
### 1. 2진수를 16진수로 변환하기
2진수를 10진수로 바꾼 뒤, 16으로 나눠서 나머지로 계산한다.

### 2. 10진수를 2진수 배열로 변환하기
- 10진수를 2진수로 나눠서 나머지와 몫을 이용해 구한다.
<br>

```java
    public ArrayList<Boolean> dec2bin(int decimal) {
        ArrayList<Boolean> binaryArr = new ArrayList<>();
        int remainer;
        boolean zero = false;
        while (decimal != 0) {
            remainer = decimal % 2;
            binaryArr.add(int2bool(remainer));
            decimal /= 2;
        }
        binaryArr.add(zero);
        return binaryArr;
    }
```


### 3. 2진수 배열을 10진수로 변환하기
- 2진수의 자리수에 따라 곱하기를 한다.
<br>

```java
    public int int2dec(ArrayList<Integer> intArr) {
        int answer = 0;
        for (int i = 0; i < intArr.size(); i++) {
            answer += intArr.get(i) * (Math.pow(2,i));
        }
        return answer;
    }
```