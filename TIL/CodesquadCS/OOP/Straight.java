package CodesquadCS.OOP;

import java.util.ArrayList;

public class Straight extends Geometry {
    public static void main(String[] args) {
        Geometry s = new Geometry();
        String coordinate = s.command();
        int[] numArr = s.coordinate2Num(coordinate);

        ArrayList<Double> distance = s.getDistance(numArr);
        System.out.printf("두 점 사이의 거리는 %f이다", distance.get(0));
        s.printCoordinate(3,10);
    }
}
