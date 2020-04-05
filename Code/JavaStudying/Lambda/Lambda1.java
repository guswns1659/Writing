package JavaStudying.Lambda;

interface Printable {
    void print(String s);
}

//class Printer implements Printable{
//
//    @Override
//    public void print(String s) {
//        System.out.println(s);
//    }
//}

public class Lambda1 {
    public static void showString(Printable p, String s) {
        p.print(s);
    }

    public static void main(String[] args) {
        showString(s -> {
            System.out.println(s);
        }, "What is Lamdba?");
    }
}


