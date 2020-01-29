package JavaStudying.Enum;

enum Transportation {
    BUS(100) { int calculateFare(int distance) {return distance * BASIC_FARE;}},
        TRAIN(150) { int calculateFare(int distance) {return distance * BASIC_FARE;}},
        SHIP(100) { int calculateFare(int distance) {return distance * BASIC_FARE;}},
        AIRPLANE(300) { int calculateFare(int distance) {return distance * BASIC_FARE;}};

    protected final int BASIC_FARE;

    Transportation(int basicFare) {
        this.BASIC_FARE = basicFare;
    }

    abstract int calculateFare(int distance);

    public int getBASIC_FARE() {
        return BASIC_FARE;
    }
}

public class EnumMain {
    public static void main(String[] args) {
        for (Transportation transportation : Transportation.values()){
            System.out.println(transportation.calculateFare(100)+"원");
        }
    }
}
