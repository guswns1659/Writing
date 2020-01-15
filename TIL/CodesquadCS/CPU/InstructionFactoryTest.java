package CodesquadCS.CPU;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InstructionFactoryTest {
    static String[] binaryArr;
    static String expected;
    static Cpu cpu;
    static Execute instructionFactory;

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
        instructionFactory = new Execute(hexNum);
        System.out.println(instructionFactory.getInstruction());
    }
}