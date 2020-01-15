package CodesquadCS.CPU;

public class Execute {

    private InstructionEnum instruction;
    private String convertedBinaryCommand;
    private String command;
    private String[] elementArr;

    Cpu2 cpu2 = new Cpu2();

    public Execute(String convertedBinaryCommand) {
        this.convertedBinaryCommand = convertedBinaryCommand;
        this.command = this.convertedBinaryCommand.substring(0, 4);

    }

    public InstructionEnum getInstruction() {
        return instruction;
    }

    public void execute () {
        switch (this.command) {
            case "0001":
                regLoad();
                break;
            case "0010":
                instruction = InstructionEnum.LOAD;
                break;
            case "0011":
                instruction = InstructionEnum.STORE;
                break;
            case "0100":
                instruction = InstructionEnum.STORE;
                break;
            case "0101":
                instruction = InstructionEnum.AND;
                break;
            case "0111":
                instruction = InstructionEnum.OR;
                break;
            case "1000":
                instruction = InstructionEnum.ADD;
                break;
            case "1001":
                instruction = InstructionEnum.SUB;
                break;
            case "1010":
                break;
            case "1011":
                instruction = InstructionEnum.MOV;
                mov();
                print(instruction);
                break;
            default:
                System.out.println("Wrong input");
                return;
        }

    }


    private void print(InstructionEnum instruction) {
        System.out.printf("실행된 pc의 값 : %s\n", cpu2.getRegister().get("pc"));
        System.out.printf("현재 실행된 명령 : %s\n", instruction);
    }

    public void regLoad() {
    }

    public void mov() {
        String dstReg = this.convertedBinaryCommand.substring(4,7);
        int value = Integer.parseInt(this.convertedBinaryCommand.substring(7));
        cpu2.getRegister().put(dstReg, value);
    }

}
