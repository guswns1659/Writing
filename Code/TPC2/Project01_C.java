package TPC2;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.InputStream;

public class Project01_C {
    public static void main(String[] args) {
        // 1. json 파일에서 json 데이터 불러오기
        String src = "info.json";
        InputStream is = Project01_C.class.getResourceAsStream(src);
        if (is == null) {
            throw new NullPointerException("Cannot find resource file");
        }
        // 2. 읽어온 json 데이터를 메모리에 로딩하기  : JSONTokener 객체 사용
        JSONTokener jsonTokener = new JSONTokener(is);

        // 3. JSONTokener 객체를 JSONObject 객체로 만들기
        JSONObject students = new JSONObject(jsonTokener);

        // 4. Json 객체에 있던 jsonArray 꺼내기
        JSONArray studentArr = students.getJSONArray("students");

        // 5. jsonArray 안에 있는 student 객체 출력하기.
        for (int i = 0; i < studentArr.length(); i++) {
            JSONObject student = studentArr.getJSONObject(i);
            System.out.println(student);
        }
    }
}
