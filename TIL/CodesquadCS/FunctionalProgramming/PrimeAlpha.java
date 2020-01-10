package CodesquadCS.FunctionalProgramming;

import java.util.*;

public class PrimeAlpha extends Factors{
    private int number;

    public PrimeAlpha(int number) {
        super(number);
    }

    public boolean isPrime() {
        number = this.number;
        Set<Integer> primeSet = new HashSet<Integer>(){ {add(1); add(number);} };
        return number > 1 && factors().equals(primeSet);
    }
    public static void main(String[] args) {
        PrimeAlpha prime1 = new PrimeAlpha(10);
        PrimeAlpha prime2 = new PrimeAlpha(7);

        System.out.println(prime1.isPrime());
        System.out.println(prime2.isPrime());
    }
}
