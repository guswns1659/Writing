package CodesquadCS.CPU;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructionFactoryTest {
    static String[] binaryArr;
    static String expected;
    static Cpu cpu;
    static InstructionFactory instructionFactory;

    @BeforeEach
    void beforeEach() {
        binaryArr = null;
        expected = "";
        cpu = new Cpu();
        instructionFactory = null;
    }
    // 0001001010000011
    // 0001001010000011
    @Test
    void InstructionFactory() {
        String hexNum = "0x1283";
        instructionFactory = new InstructionFactory(hexNum);
        System.out.println(instructionFactory.getTempResult());
        System.out.println(instructionFactory.getInstruction());
    }
}