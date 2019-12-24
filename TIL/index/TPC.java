package index;

import kr.tpc.*;

public class TPC {
    public static void main(String[] args) {
        // 1. 다형성 인수
        Dog d = new Dog();
        display(d);
        Cat c = new Cat();
        display(c);
        System.out.println("---------------------");
        // 2. 다형성 배열
        Animal[] ani = new Animal[2];
        ani[0] = new Dog();
        ani[1] = new Cat();

        for (Animal animal : ani) {
            animal.eat();
            if (animal instanceof Cat) {
                ((Cat)animal).night();
            }
        }
    }


    private static void display(Animal r) {
        r.eat();
        if (r instanceof Cat) {
            ((Cat)r).night();
        }
    }
}
