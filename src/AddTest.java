import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddTest {

    private Add adder;

    @BeforeEach
    void setUp() {
        adder = new Add();
    }

    @Test
    void add() {
        assertEquals(5, adder.add(2, 3));
    }
}
