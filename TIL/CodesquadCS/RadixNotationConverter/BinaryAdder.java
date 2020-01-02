package CodesquadCS.RadixNotationConverter;
import java.util.ArrayList;
import java.util.Arrays;

public class BinaryAdder {
    public static void main(String[] args) {
        BinaryAdder add = new BinaryAdder();
        boolean[] byteA = {true, true, false, true, true, false, true, false};
        boolean[] byteB = {true, false, true, true, false, false, true, true};
        boolean[] byteC = {true, true, false, false, true, false, true, false};
        boolean[] byteD = {true, true, false, true, true, false, false, true};
        System.out.println(add.adder(byteA, byteB));
        System.out.println(add.adder(byteC, byteD));
    }

    // 논리게이트
    // AND 게이트
    public boolean and(boolean bitA, boolean bitB) {
        if (bitA && bitB) {
            return true;
        } else {
            return false;
        }
    }
    // OR게이트
    public boolean or(boolean bitA, boolean bitB) {
        if (!bitA && !bitB) {
            return false;
        } else {
            return true;
        }
    }
    // NAND 게이트
    public boolean nAnd(boolean bitA, boolean bitB) {
        return !and(bitA, bitB);
    }

    // NOR 게이트
    public boolean nOr(boolean bitA, boolean bitB) {
        return !or(bitA, bitB);
    }

    // 합
    public boolean sum(boolean bitA, boolean bitB) {
        if (bitA && bitB) {
            return false;
        } else if (!bitA && !bitB) {
            return false;
        } else {
            return true;
        }
    }

    // 자리올림
    public boolean carry(boolean bitA, boolean bitB) {
        if (bitA && bitB) {
            return true;
        } else {
            return false;
        }
    }

    // 반가산기. true = 1, false = 0, {carry, sum}
    public boolean[] halfAdder(boolean bitA, boolean bitB) {
        boolean[] answer = {true, true};
        if (bitA && bitB) {
            answer[0] = carry(bitA, bitB);
            answer[1] = sum(bitA, bitB);
        } else if (!bitA && !bitB) {
            answer[0] = carry(bitA, bitB);
            answer[1] = sum(bitA, bitB);
        } else {
            answer[0] = carry(bitA, bitB);
            answer[1] = sum(bitA, bitB);
        }
        return answer;
    }

    // 전체덧셈
    public boolean[] fullAdder(boolean bitA, boolean bitB, boolean carry) {
        boolean[] answer = new boolean[2];

        // 1. bitA와 bitB의 반가산기1
        boolean[] result =halfAdder(bitA, bitB);
        boolean fisrtSum = result[1];

        // 2. 반가산기 합과 carry의 반가산기2
        boolean secondSum = halfAdder(fisrtSum, carry)[1];
        answer[1] = secondSum;

        // 3. 반가산기2의 carry와 or논리게이트
        boolean fisrtCarry = result[0];
        boolean secondCarry = halfAdder(fisrtSum, carry)[0];

        // 4. 반가산기2의 합과 or논리게이트 결과
        answer[0]=or(fisrtCarry, secondCarry);
        return answer;
    }

    // Adder, 8비트 덧셈기
    public ArrayList<Boolean> adder(boolean[] byteA, boolean[] byteB) {
        ArrayList<Boolean> answer = new ArrayList<>();
        boolean carry = false;
        boolean elements;
        boolean[] result;
        for (int i = 0; i < byteA.length; i++) {
            result = fullAdder(byteA[i], byteB[i], carry);
            carry = result[0];
            elements = result[1];
            answer.add(elements);
        }
        // 배열 다 순회하고 나올 때 carry가 1이면 배열에 더한다.
        answer.add(carry);
        return answer;
    }
}
