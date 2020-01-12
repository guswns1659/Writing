package CodesquadCS.OOP;

import java.util.List;

public class Line implements Shape {
    private Points points1;
    private Points points2;

    public Line(Points points1, Points points2) {
        this.points1 = points1;
        this.points2 = points2;
    }

    public Points getPoints1() {
        return points1;
    }

    public void setPoints1(Points points1) {
        this.points1 = points1;
    }

    public Points getPoints2() {
        return points2;
    }

    public void setPoints2(Points points2) {
        this.points2 = points2;
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
        return 0;
    }
}
