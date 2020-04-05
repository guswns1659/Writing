package TPC1;

import kr.tpc.A;
import kr.tpc.B;

import java.util.ArrayList;

public class TPC47 {
    public static void main(String[] args) {
        // Object 배열 사용하기
//        ObjectArray arr = new ObjectArray(3);
        ArrayList arr;
        arr = new ArrayList(3);
        arr.add(new A());
        arr.add(new B());
        arr.add(new A());
        arr.add(new A());
        arr.add(new A());
        arr.add(new A());

        for (int i = 0; i < arr.size(); i++) {
            Object o = arr.get(i);
            if (o instanceof A) {
                ((A) o).go();
            } else {
                ((B) o).go();
            }
        }
    }

}
