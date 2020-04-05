package kr.poly;

public class Dog extends Animal {
    private int price = 100;

    @Override
    public void eat() {
        System.out.println("왈왈 맛있어!");
    }

}
