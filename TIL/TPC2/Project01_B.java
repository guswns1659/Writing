package TPC2;

import org.json.JSONArray;
import org.json.JSONObject;

public class Project01_B {
    public static void main(String[] args) {
        // JSON-java 이용해 json 객체 만들고 출력하기

        // 1. student json 객체 만들기
        JSONObject student = new JSONObject();
        student.put("name", "son");
        student.put("phone", "010-1111-1111");
        student.put("address", "광주");

        JSONObject student2 = new JSONObject();
        student2.put("name", "jun");
        student2.put("phone", "010-2222-2222");
        student2.put("address", "서울");

        // 2. students json 배열 만들기
        JSONArray students = new JSONArray();
        students.put(student);
        students.put(student2);

        // 3. object json 객체 만들기
        JSONObject object = new JSONObject();
        object.put("students", students);
        System.out.println(object.toString(2));
    }
}
