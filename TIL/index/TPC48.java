package index;

import kr.tpc.BookDTO;

import java.util.ArrayList;

public class TPC48 {
    public static void main(String[] args) {
        ArrayList<BookDTO> arr = new ArrayList<>();
        arr.add(new BookDTO("java", 15000, "google"));
        arr.add(new BookDTO("python", 20000, "amazon"));

        for (BookDTO obj : arr) {
            System.out.println(obj.toString());
        }
    }
}
