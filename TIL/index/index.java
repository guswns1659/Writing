package index;
import com.google.gson.Gson;

public class index {
    public static void main(String[] args) {
        // 1. 자바가 기본으로 제공하는 클래스..
        String str;
        str = "I love you";
        int index = str.indexOf("I");
        System.out.println(index);

        // 2. 내가 직접 설계하는 클래스.. DTO, DAO, Utility
        Book book = new Book("java", 15000);
        int answer = book.hap();
        System.out.println(answer);

        // 3. 외부에서 가져오는 클래스 .. Gson
        Gson g = new Gson();
        String json = g.toJson(book);
        System.out.println(json);
    }
}