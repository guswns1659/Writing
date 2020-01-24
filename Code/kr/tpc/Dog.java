package kr.tpc;

public class Dog extends Animal {
    // 부모 클래스에 상태 정보가 있기 때문에 자식 클래스 생성자에서 초기화 생성자를 만들어야 한다.

    public void eat() {
        System.out.println("왈왈 맛있어");
    }
}
