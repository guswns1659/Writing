package CodesquadCS.DataStructure.HashMap;


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        hashMap.put("apple", "사과");
        hashMap.put("apple", "잡스");
        hashMap.put("dog", "또치");
        hashMap.put("dog", "치와와");
        hashMap.put("cat", "페르시안");
        System.out.println(Arrays.toString(hashMap.keys()));
    }
}
