package CodesquadCS.CPU;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Cpu2Test {

    Cpu2 cpu2 = new Cpu2();
    String[] programs = new String[]{"0xB8FA", "0x1283", "0x3AC4", "0x2EBE"};



    @BeforeEach
    void beforeEach() {
        Cpu2 cpu2;
    }

    @Test
    void checkRegisterInit() {
        Cpu2 cpu2 = new Cpu2();
        System.out.println(cpu2.getRegister().keySet());
    }

    @Test
    void checkMemoryInit() {
        Memory memory = new Memory();
        System.out.println(memory.getMemory().keySet());
    }

    @Test
    void cpu2Test() {
        cpu2.load(programs);
        String hexCommand = cpu2.fetch();
        String convertedBinaryCommand = cpu2.hex2bin(hexCommand);
        System.out.println(cpu2.getRegister().get("100"));
        cpu2.execute(convertedBinaryCommand);
        System.out.println(cpu2.getRegister().get("100"));
    }


}