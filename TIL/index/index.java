package index;

public class index {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();

        Cat c = new Cat();
        c.eat();

        Animal ani = new Dog(); // 자동 형변환(자식 -> 부모), upCasting
        ani.eat();

        ani = new Cat();
        ((Cat)ani).night(); // 강제 형변환(부모 -> 자식), downCasting
    }
}