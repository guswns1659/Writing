package CodesquadCS.CPU;

public class InstructionFactory {

    private Instruction instruction;
    private String binCommand;
    private String[] elementArr;


    public InstructionFactory(String hexCommand) {
        this.binCommand = hex2bin(hexCommand);
        parseCommand();

    }

    public Instruction getInstruction() {
        return instruction;
    }

    public String getTempResult() {
        return binCommand;
    }


    public String hex2bin (String hexCommand) {
        String binaryResult = Integer.toBinaryString(Integer.parseInt(hexCommand.substring(2), 16));
        int binaryResultLength = binaryResult.length();
        for (int i = 0; i < 16 - binaryResultLength; i++) {
            binaryResult = "0" + binaryResult;
        }
        return binaryResult;
    }

    private void parseCommand () {
        String delimeter = this.binCommand.substring(0, 4);

        switch (delimeter) {
            case "0001":
                instruction = Instruction.LOAD;
                break;
            case "0010":
                instruction = Instruction.LOAD;
                break;
            case "0011":
                instruction = Instruction.STORE;
                break;
            case "0100":
                instruction = Instruction.STORE;
                break;
            case "0101":
                instruction = Instruction.AND;
                break;
            case "0111":
                instruction = Instruction.OR;
                break;
            case "1000":
                instruction = Instruction.ADD;
                break;
            case "1001":
                instruction = Instruction.SUB;
                break;
            case "1010":
                instruction = Instruction.SUB;
                break;
            case "1011":
                instruction = Instruction.MOV;
                break;
            default:
                System.out.println("Wrong input");
                return;
        }

    }
    
}
