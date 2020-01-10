package CodesquadCS.FunctionalProgramming;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Factors {
    private int number;

    public Factors(int number) {
        this.number = number;
    }

    // 외부 객체의 상태 변수를 가져오는 것이 아니라 한번 복사한다.
    public boolean isFactor(int potentialFactor) {
        number = this.number;
        return number % potentialFactor == 0;
    }

    public Set<Integer> factors() {
        HashSet<Integer> factors = new HashSet<>();
        number = this.number;
        for (int pod=1; pod <= Math.sqrt(number); pod++) {
            if (isFactor(pod)) {
                factors.add(pod);
                factors.add(number / pod);
            }
        }
        return factors;

    }


}
