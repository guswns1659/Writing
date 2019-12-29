package TPC2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import kr.tpc.BookDTO;

import java.util.ArrayList;

public class Project01_A {
    public static void main(String[] args) {
        // Gson으로 객체를 json형식 문자열로 바꾸기
        BookDTO b = new BookDTO("java", 15000, "한빛");
        Gson g = new Gson();
        String json = g.toJson(b);
        System.out.println(json);
        // Gson으로 json을 객체로 바꾸기
        BookDTO book = g.fromJson(json, BookDTO.class);
        System.out.println(book);
        // Gson으로 List를 Json으로 바꾸기
        ArrayList<BookDTO> arr = new ArrayList<>();
        arr.add(new BookDTO("python", 1400, "이지"));
        arr.add(new BookDTO("JS", 1400, "하드"));
        String arrJson = g.toJson(arr);
        System.out.println(arrJson);

        // Gson을 활용하여 Json을 List로 바꾸기
        TypeToken<ArrayList<BookDTO>> typeToken= new TypeToken<ArrayList<BookDTO>>(){};
        ArrayList<BookDTO> arr2 = g.fromJson(arrJson, typeToken.getType());
        for (BookDTO value : arr2) {
            System.out.println(value);
        }
    }
}
