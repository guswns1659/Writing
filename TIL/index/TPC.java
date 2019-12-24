package index;

import kr.poly.Radio;
import kr.poly.RemoCon;
import kr.poly.TV;

public class TPC {
    public static void main(String[] args) {
        RemoCon r = new TV();
        for (int i = 0; i < 40; i++) {
            r.chDown();
        }
        for (int i = 0; i < 40; i++) {
            r.chUp();
        }
        r.internet();

        r = new Radio();
        r.chDown();
        r.chUp();
        r.internet();
    }

}
