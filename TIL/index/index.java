package index;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class index {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>(2);
        map.put(0, 15000);
        map.put(1, 15000);

        System.out.println(map.keySet());

        // get all elements of map
        for (Integer key : map.keySet()){
            int value = map.get(key);
            System.out.println("value : " + value);
        }
        // 배열
        int[] arr = new int[3];
        System.out.println(arr.getClass());

    }
}
