package TPC2;

import com.google.gson.Gson;
import com.google.gson.internal.bind.util.ISO8601Utils;
import com.google.gson.reflect.TypeToken;
import kr.tpc.BookDTO;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

public class Project01_A {
    public static void main(String[] args) {
        // Gson으로 객체를 json형식 문자열로 바꾸기
        BookDTO b = new BookDTO("java", 5000, "한빛미디어");
        Gson g = new Gson();
        String json = g.toJson(b);
        System.out.println(json);

        // Gson으로 json을 객체로 바꾸기
        BookDTO book = g.fromJson(json, BookDTO.class);
        System.out.println(book.toString());

        // Gson으로 List를 Json으로 바꾸기
        List<BookDTO> list = new ArrayList<>();
        list.add(new BookDTO("python", 1000, "note"));
        list.add(new BookDTO("c", 10000, "please"));
        String json2 = g.toJson(list);
        System.out.println(json2);

        // Gson을 활용하여 Json을 List로 바꾸기
        List<BookDTO> list2 = g.fromJson(json2, new TypeToken<List<BookDTO>>(){}.getType());
        for (BookDTO v : list2) {
            System.out.println(v);
        }
    }
}
