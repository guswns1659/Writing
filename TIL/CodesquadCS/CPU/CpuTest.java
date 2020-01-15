package CodesquadCS.CPU;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CpuTest {

    static String[] hexCommandArr;
    static String expected;
    static Cpu cpu;

    @BeforeEach
    void beforeEach() {
        hexCommandArr = null;
        expected = "";
        cpu = new Cpu();
    }

    @Test
    void load() {
        hexCommandArr = new String[]{"0x1283"};
        System.out.println(cpu.load(hexCommandArr));
    }
    @Test
    void fetch() {
        hexCommandArr = new String[]{"1011100010110000"};
        System.out.println(cpu.getRegister().get(0));
        cpu.fetch(hexCommandArr);
        System.out.println(cpu.getRegister().get(0));
    }
}