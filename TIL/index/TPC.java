package index;

import kr.tpc.Animal;
import kr.tpc.Cat;
import kr.tpc.Dog;

public class TPC {
    public static void main(String[] args) {
        Animal ani = new Animal() {
            @Override
            public void eat() {
                System.out.println("모든 동물을 밥을 먹어요.");
            }
        };
        ani = new Cat();
        ((Cat)ani).night();
    }
}
