package CodesquadCS.OOP;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputTest {
    InputUtilty input = new InputUtilty();
    @Test
    void askCoordinate() {

    }

    @Test
    void testAskCoordinate() {

    }

    @Test
    void inputParser() {
        assertEquals("3,4,5,7", input.inputParser("(3,4)-(5,7)"));
    }

    @Test
    void isVaildCoordinate() {
        int[] arr= {3,4,5,7};
        assertTrue(input.isVaildCoordinate(arr));
    }
}