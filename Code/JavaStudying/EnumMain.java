package JavaStudying;

enum Fruit {
    APPLE("red"), PEACH("pink"), BANANA("yellow");

    private final String color;

    Fruit(String color) {
        System.out.println("call constructor "+this);
        this.color = color;
    }
    public String getColor() {
        return color;
    }
}

public class EnumMain {
    public static void main(String[] args) {
        Fruit type = Fruit.APPLE;
        switch (type) {
            case APPLE:
                System.out.println(57+"kcal, color : "+Fruit.APPLE.getColor());
                break;
            case PEACH:
                System.out.println(34+"kcal, color : "+Fruit.PEACH.getColor());
                break;
            case BANANA:
                System.out.println(93+"kcal, color : "+Fruit.BANANA.getColor());
                break;
        }
    }
}
