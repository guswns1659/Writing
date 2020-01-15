package CodesquadCS.Algorithm.NumberOfKth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfKthTest {

    public int[] expected = new int[]{5, 6, 3};
    public int[][] command = new int[3][3];
    public int[] indexModifiedCommand = new int[]{1, 5, 3};
    public int[] array = new int[]{1, 5, 2, 6, 3, 7, 4};
    public int[] slicedArr = new int[]{5, 2, 6, 3};
    public int[] sortedArr = new int[]{2, 3, 5, 6};

    NumberOfKth numberOfKth = new NumberOfKth();

    @BeforeEach
    void beforeEach() {

    }
    @Test
    void solution() {
        command[0] = new int[]{2, 5, 3};
        command[1] = new int[]{4, 4, 1};
        command[2] = new int[]{1, 7, 3};

        assertArrayEquals(expected, numberOfKth.solution(array, command));
    }
    @Test
    void commandIndexModify() {
        assertArrayEquals( expected, numberOfKth.commandIndexModify(array));
    }
    @Test
    void sliceArr() {
        assertArrayEquals(expected, numberOfKth.sliceArr(array, indexModifiedCommand));
    }

    @Test
    void sortArr() {
        assertArrayEquals(expected, numberOfKth.sortArr(slicedArr));
    }
    @Test
    void getNumberOfKth() {
        assertEquals(5, numberOfKth.getNumberOfKth(sortedArr, indexModifiedCommand
        ));
    }
}