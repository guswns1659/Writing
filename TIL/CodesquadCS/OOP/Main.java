package CodesquadCS.OOP;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Inputer inputer = new Inputer();
        List<Points> pointsList = inputer.start();
        ShapeChecker shapeChecker = new ShapeChecker();
        double result = shapeChecker.calculate(pointsList);
        System.out.println(result);
    }
}
