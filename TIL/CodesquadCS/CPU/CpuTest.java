package CodesquadCS.CPU;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CpuTest {

    static String[] binaryArr;
    static String expected;
    static Cpu cpu;

    @BeforeEach
    void beforeEach() {
        binaryArr = null;
        expected = "";
        cpu = new Cpu();
    }

    @Test
    void load() {
//        binaryArr = new String[]{"1011100010110000"};
        System.out.println(Instruction.ADD);

    }
}