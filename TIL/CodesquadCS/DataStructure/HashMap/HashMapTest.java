package CodesquadCS.DataStructure.HashMap;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class HashMapTest {
    HashMap hashMap = new HashMap();

    @Test
    void put() {
        assertNull(hashMap.put("apple", "사과"));
    }

    @Test
    void get() {

    }

    @Test
    void remove(){
        hashMap.put("apple", "사과");
        hashMap.put("apple", "사과");
        assertEquals("사과", hashMap.remove("apple"));
        assertEquals("ㅇㅇ", hashMap.remove("dog"));
//        assertNull(hashMap.remove("dog"));
    }

    @Test
    void isEmpty() {
        assertEquals(true, hashMap.isEmpty());
    }

    @Test
    void size() {
        hashMap.put("apple", "사과");
        assertEquals(1, hashMap.size());
    }

    @Test
    void clear() {
        hashMap.put("apple", "사과");
        hashMap.clear();

        assertTrue(hashMap.isEmpty());
    }

    @Test
    void keys() {
        hashMap.put("apple", "사과");
        hashMap.put("dog", "치와와");
        hashMap.put("dog", "말티즈");
        Arrays.toString(hashMap.keys());
    }
}