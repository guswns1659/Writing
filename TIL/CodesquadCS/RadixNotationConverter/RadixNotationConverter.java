package CodesquadCS.RadixNotationConverter;

import java.util.ArrayList;

public class RadixNotationConverter {
    public static void main(String[] args) {
        RadixNotationConverter c = new RadixNotationConverter();
        ArrayList<Boolean> result = c.dec2bin(173);
        ArrayList<Integer> result2 = c.bin2int(result);
        System.out.println(c.int2dec(result2));
    }

    // int를 boolean으로 변환하는 함수로 쪼개기
    public boolean int2bool(int remainer) {
        if (remainer == 0) {
            return false;
        } else {
            return true;
        }
    }

    // 10진수를 2진수 배열로 변환하는 함수
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

    // 2진수 배열 원소를 int로 변환하는 함수
    public ArrayList<Integer> bin2int(ArrayList<Boolean> binaryArr) {
        ArrayList<Integer> intArr = new ArrayList<>();
        for (int i = 0; i < binaryArr.size(); i++) {
            if(binaryArr.get(i)){
                intArr.add(1);
            } else {
                intArr.add(0);
            }
        }
        return intArr;
    }

    // 2진수 배열을 10진수로 변환하는 함수
    public int int2dec(ArrayList<Integer> intArr) {
        int answer = 0;
        for (int i = 0; i < intArr.size(); i++) {
            answer += intArr.get(i) * (Math.pow(2,i));
        }
        return answer;
    }
}

