package kr.poly;

public class Radio implements RemoCon {
    @Override
    public void chUp() {
        System.out.println("라디오 채널이 올라간다");
    }

    @Override
    public void chDown() {
        System.out.println("라디오 채널이 내려간다");

    }

    @Override
    public void internet() {
        System.out.println("라디오는 인터넷이 안되요");

    }
}
