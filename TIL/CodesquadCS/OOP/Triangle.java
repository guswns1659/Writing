package CodesquadCS.OOP;

import java.util.ArrayList;
import java.util.List;

public class Triangle implements Shape {
    private Points points1;
    private Points points2;
    private Points points3;

    public Triangle(Points points1, Points points2, Points points3) {
        this.points1 = points1;
        this.points2 = points2;
        this.points3 = points3;
    }

    @Override
    public double getDistanceBWCoordinates(Points points1, Points points2) {
        int x1 = points1.getX();
        int y1 = points1.getY();
        int x2 = points2.getX();
        int y2 = points2.getY();

        double length = Math.sqrt(Math.pow(Math.abs(x2-x1),2) +Math.pow(Math.abs(y2-y1),2));
        return length;
    }

    @Override
    public double getArea() {
        double line1 = getDistanceBWCoordinates(this.points1, this.points2);
        double line2 = getDistanceBWCoordinates(this.points1, this.points3);
        double line3 = getDistanceBWCoordinates(this.points2, this.points3);
        double s = 0.5 *(line1 + line2 + line3);
        double area = Math.sqrt(s * (s-line1) * (s-line2) * (s-line3));

        return area;
    }
}