package CodesquadCS.Algorithm;

import java.util.Arrays;
import java.util.HashMap;

public class PoorRunner {
    public static void main(String[] args) {
        PoorRunner p = new PoorRunner();
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"kiki", "eden"};
        System.out.println(p.solution(participant, completion));
    }

    // 배열 이용하는 법
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        return participant[completion.length];
    }
    // HashMap 이용하는 법
    public String solution2(String[] participant, String[] completion) {
        HashMap<String, Integer> hash = new HashMap<>();
        for (String player : participant) {
            hash.put(player, hash.getOrDefault(player, 0) +1);
        }
        for (String finisher : completion) {
            hash.put(finisher, hash.get(finisher) -1);
        }

        for (String key : hash.keySet()) {
            if(hash.get(key) != 0) {
                return key;
            }
        }
        return null;
    }

}
