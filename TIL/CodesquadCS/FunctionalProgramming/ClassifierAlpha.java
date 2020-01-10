package CodesquadCS.FunctionalProgramming;
import java.util.*;

public class ClassifierAlpha extends Factors{
    private int number;

    public ClassifierAlpha(int number) {
        super(number);
    }

    static public int sum(Set<Integer> factors) {
        int sumAll = factors.stream().reduce(0, (x,y)->x+y);
        return sumAll;
    }

    public boolean isPerfect() {
        return sum(factors()) - number == number;
    }

    public boolean isAbundant() {
        return sum(factors()) - number > number;
    }

    public boolean isDeficient() {
        return sum(factors()) - number < number;
    }
    public static void main(String[] args) {
        ClassifierAlpha alpha1 = new ClassifierAlpha(10);
        ClassifierAlpha alpha2 = new ClassifierAlpha(6);

        System.out.println(alpha1.isDeficient());
        System.out.println(alpha2.isPerfect());
    }
}
