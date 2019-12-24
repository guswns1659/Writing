package kr.poly;

public abstract class Animal {
    public static final int MAXCH = 100;
    public abstract void eat();
    public void move() {
        System.out.println("무리를 지어 이동한다.");
    }
}
