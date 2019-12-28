package TPC1;

import kr.tpc.IntArray;

public class TPC46 {
    public static void main(String[] args) {
        IntArray arr = new IntArray(3);
        arr.add(10);
        arr.add(20);
        arr.add(30);

        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
    }
}
