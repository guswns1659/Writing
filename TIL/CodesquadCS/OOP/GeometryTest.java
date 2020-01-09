package CodesquadCS.OOP;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GeometryTest {
    Geometry s = new Geometry();
    @Test
    void coordinate2Num() {
        int[] answer = {3, 10};
        assertArrayEquals(answer, s.singleCoordinate2Num("(3,10)"));
    }


    @Test
    void command() {
        assertEquals("(3,10)", s.command());
    }
    @Test
    void doubleCoordinate2Num() {
        int[] answer = {3,10,4,11};
        assertArrayEquals(answer, s.doubleCoordinate2Num("(3,10)-(4,11)"));
    }

    @Test
    void getDistance() {
    }
    @Test
    void getDistanceOfTwoCoordinate(){
        ArrayList<Double> answer = new ArrayList<>();
        answer.add(6.4031242374328485);
        int[] args = {3,10,4,11};
//        assertArrayEquals(answer, s.getDistanceOfTwoCoordinate(args));
    }


}