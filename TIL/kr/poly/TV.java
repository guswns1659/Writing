package kr.poly;

public class TV implements RemoCon {
    int currCH = 70;

    @Override
    public void chUp() {
        if (currCH < RemoCon.MAXCH) {
            currCH++;
        } else {
            currCH = 1;
        }
        System.out.printf("TV 채널이 올라간다. : %d\n", currCH);
    }

    @Override
    public void chDown() {
        if (currCH > RemoCon.MINCH) {
            currCH--;
        } else {
            currCH = 100;
        }
        System.out.printf("TV 채널이 내려간다. : %d\n", currCH);
    }

    @Override
    public void internet() {
        System.out.println("Tv는 인터넷이 됩니다.");
    }
}
