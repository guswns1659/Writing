package CodesquadCS.CPU;

import java.util.HashMap;
import java.util.Map;

public class Cpu {
    private Map<Integer, Integer> memory;
    private Map<Integer, Integer> register;


    public Cpu() {
        this.memory = new HashMap<Integer, Integer>();
        this.register = new HashMap<Integer, Integer>();
        for (int i =0; i < 8; i++) {
            this.register.put(i, i+30000);
        }
        this.register.put(0, 0);
    }

    public void load(String[] binaryArr) {
        String command = fetch(binaryArr);
        execute(command);
    }


    public void reset() {

    }

    public String fetch(String[] binaryArr) {
        String resultCommand = binaryArr[this.register.get(0)];
        this.register.put(0, this.register.get(0) +1);
        return resultCommand;
    }

    public void execute(String IR) {
        tokenizer(IR);
    }

    public void tokenizer(String command) {

    }
    public void dump() {

    }

    public void stroe() {

    }

}
