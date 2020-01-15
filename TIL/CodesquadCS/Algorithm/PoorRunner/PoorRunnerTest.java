package CodesquadCS.Algorithm.PoorRunner;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PoorRunnerTest {
    PoorRunner p = new PoorRunner();
    @Test
    void solution() {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"kiki", "eden"};
        assertEquals("leo", p.solution(participant, completion));
    }
}