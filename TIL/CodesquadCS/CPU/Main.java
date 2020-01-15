package CodesquadCS.CPU;

public class Main {
    public static void main(String[] args) {
        String[] programs = new String[]{"0xB8FA", "0x1283", "0x3AC4", "0x2EBE"};
        Cpu2 cpu2 = new Cpu2();
        cpu2.load(programs);
        String hexCommand = cpu2.fetch();
        String convertedBinaryCommand = cpu2.hex2bin(hexCommand);
        cpu2.execute(convertedBinaryCommand);
    }
}
