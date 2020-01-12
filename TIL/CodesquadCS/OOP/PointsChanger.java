package CodesquadCS.OOP;

import java.util.ArrayList;
import java.util.List;

public class PointsChanger {
    public List<Points> fourCoordinatesToTwoPoints(int[] integerCoordinates) {
        List<Points> points = new ArrayList<>();
        Points points1 = new Points(integerCoordinates[0], integerCoordinates[1]);
        Points points2 = new Points(integerCoordinates[2], integerCoordinates[3]);
        points.add(points1);
        points.add(points2);
        return points;
    }

    public List<Points> sixCoordinatesToThreePoints(int[] integerCoordinates) {
        List<Points> points = new ArrayList<>();
        Points points1 = new Points(integerCoordinates[0], integerCoordinates[1]);
        Points points2 = new Points(integerCoordinates[2], integerCoordinates[3]);
        Points points3 = new Points(integerCoordinates[4], integerCoordinates[5]);
        points.add(points1);
        points.add(points2);
        points.add(points3);
        return points;
    }

    public List<Points> eightCoordinatesToFourPoints(int[] integerCoordinates) {
        List<Points> points = new ArrayList<>();
        Points points1 = new Points(integerCoordinates[0], integerCoordinates[1]);
        Points points2 = new Points(integerCoordinates[2], integerCoordinates[3]);
        Points points3 = new Points(integerCoordinates[4], integerCoordinates[5]);
        Points points4 = new Points(integerCoordinates[6], integerCoordinates[7]);
        points.add(points1);
        points.add(points2);
        points.add(points3);
        points.add(points4);
        return points;
    }

}