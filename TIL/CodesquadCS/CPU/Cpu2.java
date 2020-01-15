package CodesquadCS.CPU;

import java.util.HashMap;
import java.util.Map;

public class Cpu2 {
    private String[] programs;
    private Map<String, Integer> register;

    Memory memory = new Memory();

    public Cpu2 () {
        register = new HashMap<>();
        this.register.put("pc", 0);
        this.register.put("001", 10);
        this.register.put("010", 11);
        this.register.put("011", 12);
        this.register.put("100", 13);
        this.register.put("101", 14);
        this.register.put("110", 15);
        this.register.put("111", 16);
    }

    public Map<String, Integer> getRegister() {
        return register;
    }

    public void load(String[] programs) {
        this.programs = programs;
    }

    public String fetch() {
        int programCounter= this.register.get("pc");
        String hexCommand = this.programs[programCounter];
        this.register.put("pc", programCounter +1);
        return hexCommand;
    }

    public String hex2bin (String hexCommand) {
        String convertedBinaryCommand = Integer.toBinaryString(Integer.parseInt(hexCommand.substring(2), 16));
        int convertedBinarycommandLength = convertedBinaryCommand.length();
        for (int i = 0; i < 16 - convertedBinarycommandLength; i++) {
            convertedBinaryCommand = "0" + convertedBinaryCommand;
        }
        return convertedBinaryCommand;
    }

    public void execute(String convertedBinaryCommand) {
        Execute execute = new Execute(convertedBinaryCommand);
        execute.execute();
    }


}
