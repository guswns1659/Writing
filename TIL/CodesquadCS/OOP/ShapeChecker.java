package CodesquadCS.OOP;

import java.util.List;

public class ShapeChecker {

    public double calculate(List<Points> pointsList) {
        double result;
        if (pointsList.size() == 2) {
            result = getLineDistance(pointsList);
        } else {
            result = getTriangleArea(pointsList);
        }
        return result;
    }

    public double getLineDistance(List<Points> pointsList) {
        Points inputPoints1 = pointsList.get(0);
        Points inputPoints2 = pointsList.get(1);
        Shape shape = new Line(inputPoints1, inputPoints2);
        double LineDistance = shape.getDistanceBWCoordinates(inputPoints1, inputPoints2);
        return LineDistance;
    }

    private double getTriangleArea(List<Points> pointsList) {
        Points inputPoints1 = pointsList.get(0);
        Points inputPoints2 = pointsList.get(1);
        Points inputPoints3 = pointsList.get(2);

        Shape shape = new Triangle(inputPoints1, inputPoints2, inputPoints3);
        double triangleArea = shape.getArea();
        return triangleArea;
    }
}
