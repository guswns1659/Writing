package CodesquadCS.RadixNotationConverter;
import java.util.ArrayList;

public class BinaryAdder {
    private static final boolean ZERO = false;
    private static final boolean ONE = true;

    public static void main(String[] args) {
        BinaryAdder add = new BinaryAdder();
        boolean[] byteA = {true, true, false, true, true, false, true, false};
        boolean[] byteB = {true, false, true, true, false, false, true, true};
        boolean[] byteC = {true, true, false, false, true, false, true, false};
        boolean[] byteD = {true, true, false, true, true, false, false, true};
        System.out.println(add.byteAdder(byteA, byteB));
        System.out.println(add.byteAdder(byteC, byteD));
    }

    // 논리게이트
    // AND 게이트
    public boolean and(boolean bitA, boolean bitB) {
        if (bitA && bitB) {
            return ONE;
        } else {
            return ZERO;
        }
    }
    // OR게이트
    public boolean or(boolean bitA, boolean bitB) {
        if (!bitA && !bitB) {
            return ZERO;
        } else {
            return ONE;
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

    // Sum
    public boolean getSum(boolean bitA, boolean bitB) {
        if (bitA && bitB) {
            return ZERO;
        } else if (!bitA && !bitB) {
            return ZERO;
        } else {
            return ONE;
        }
    }

    // Carry
    public boolean getCarry(boolean bitA, boolean bitB) {
        if (bitA && bitB) {
            return ONE;
        } else {
            return ZERO;
        }
    }

    // 반가산기.
    public boolean[] halfAdder(boolean bitA, boolean bitB) {
        boolean[] answer = {ONE, ONE};
        if (bitA && bitB) {
            answer[0] = getCarry(bitA, bitB);
            answer[1] = getSum(bitA, bitB);
        } else if (!bitA && !bitB) {
            answer[0] = getCarry(bitA, bitB);
            answer[1] = getSum(bitA, bitB);
        } else {
            answer[0] = getCarry(bitA, bitB);
            answer[1] = getSum(bitA, bitB);
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

    // byteAdder, 8비트 덧셈기
    public ArrayList<Boolean> byteAdder(boolean[] byteA, boolean[] byteB) {
        ArrayList<Boolean> answer = new ArrayList<>();
        boolean carry = ZERO;
        boolean elements;
        boolean[] result;
        for (int i = 0; i < byteA.length; i++) {
            result = fullAdder(byteA[i], byteB[i], carry);
            carry = result[0];
            elements = result[1];
            answer.add(elements);
        }
        answer.add(carry);
        return answer;
    }
}
