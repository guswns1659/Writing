package kr.tpc;

public class Cat extends Animal {
    @Override
    public void eat() {
        System.out.println("고양이가 밥을 먹어요.");
    }
    public void night() {
        System.out.println("밤이 되면 눈이 반짝 빛나요.");
    }
}
