package JavaStudying;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StreamClassTest {
    private StreamClass streamClass;
    private ToyMain toyMain;
    private ReduceMain reduceMain;

    @BeforeEach
    public void beforeEach() {
        streamClass = new StreamClass();
        toyMain = new ToyMain();
        reduceMain = new ReduceMain();
    }

    @Test
    public void StringStream() {
        streamClass.stringStream();
    }

    @Test
    public void splitedIntStream() {
        streamClass.splitedIntStream();
    }

    @Test
    public void getToyPriceUnder500() {
        int expected = 550;
        assertEquals(expected, toyMain.getToyPriceUnder500());
    }

    @Test
    public void getMaxLengthString() {
        String expected = "Complex";
        assertEquals(expected, reduceMain.getMaxLengthString());
    }
}