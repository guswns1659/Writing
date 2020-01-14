package CodesquadCS.Parser;

import org.junit.jupiter.api.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ArrayParserTest {

    static String inputString;
    static String expected;
    static Parser ap;

    @BeforeEach
    void beforeEach() {
        inputString = "";
        expected = "";
        ap = new Parser();
    }

    @Test
    void makeSolidMap() {
        Map<String, Object> result = new HashMap<>();
        result = ap.makeSolidMap(1);
        System.out.println();
    }

    @Test
    void tokenizer() {
        inputString = "[1, 2, 3]";
        expected = "[1 2 3]";

        assertEquals(expected, ap.tokenizer(inputString));
    }

    @Test
    void printHashMap() {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();

        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);

        map2.put("a1", map);

        map.put("d", 4);

        map2.put("a2", map);

        System.out.println(Arrays.asList(map)); // method 1
        System.out.println(Collections.singletonList(map)); // method 2

        System.out.println();

        System.out.println(Arrays.asList(map2)); // method 1
        System.out.println(Collections.singletonList(map2)); // method 2
    }
}