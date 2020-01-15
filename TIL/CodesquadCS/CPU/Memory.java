package CodesquadCS.CPU;

import java.util.HashMap;
import java.util.Map;

public class Memory {
    private Map<String, Integer> memory;

    public Memory() {
        memory = new HashMap<>();
        for(int i = 0; i < 100; i++) {
            memory.put(String.valueOf(i), 0);
        }
    }

    public Map<String, Integer> getMemory() {
        return memory;
    }
}
