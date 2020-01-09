package CodesquadCS.OOP;

import java.util.ArrayList;
import java.util.HashSet;

public class Rectangle extends Geometry {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        String coordinate = rectangle.command();
        int[] numArr = rectangle.coordinate2Num(coordinate);
        ArrayList<Double> distances = rectangle.getDistance(numArr);
        ArrayList<Double> uniqueItems = rectangle.removeOverlap(distances);
        double answer = rectangle.getArea(uniqueItems);
        System.out.println(answer);
    }
    public ArrayList<Double> removeOverlap(ArrayList<Double> distances) {
        ArrayList<Double> uniqueItems = new ArrayList<Double>(new HashSet<Double>(distances));
        if (uniqueItems.size() == 2){
           ArrayList<Double> min  = getMinDistanceOfTwo(uniqueItems);
        } else {
            ArrayList<Double> twoDistances = getMinDistanceOfThree(uniqueItems);
        }
        return uniqueItems;
    }
    public ArrayList<Double> getMinDistanceOfTwo(ArrayList<Double> uniqueItems) {
        double min1 = Math.min(uniqueItems.get(0), uniqueItems.get(1));
        ArrayList<Double> min = new ArrayList<>();
        min.add(0, min1);
        return min;
    }
    public ArrayList<Double> getMinDistanceOfThree(ArrayList<Double> uniqueItems) {
        double max = uniqueItems.get(0);
        for (int i = 0; i < uniqueItems.size(); i++) {
            if (uniqueItems.get(i) > max) {
                max = uniqueItems.get(i);
            } else {
                continue;
            }
        }
        uniqueItems.remove(max);
        return uniqueItems;
    }

    public double getArea(ArrayList<Double> uniqueItems) {
        double area;
        if (uniqueItems.size() == 1) {
            area = Math.pow(uniqueItems.get(0),2);
        } else {
            double a = uniqueItems.get(0);
            double b = uniqueItems.get(1);
            area = a * b * 0.5;
        }
        return area;
    }

}
