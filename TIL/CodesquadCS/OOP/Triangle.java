package CodesquadCS.OOP;

import java.util.ArrayList;

public class Triangle extends Geometry{
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        String coordinate = triangle.command();
        int[] numArr = triangle.coordinate2Num(coordinate);
        ArrayList<Double> distances = triangle.getDistance(numArr);
        double area = triangle.getArea(distances);
        System.out.printf("삼각형의 넓이는 %f", area);
    }
    public double getArea(ArrayList<Double> distances){
        double a = distances.get(0);
        double b = distances.get(1);
        double c = distances.get(2);
        double sum = 0.5 * (a+b+c);
        double result = sum * (sum - a) * (sum - b) * (sum - c);
        double area = Math.sqrt(result);
        return area;
    }



}
