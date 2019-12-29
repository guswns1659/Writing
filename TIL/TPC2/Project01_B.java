package TPC2;

import org.json.JSONArray;
import org.json.JSONObject;

public class Project01_B {
    public static void main(String[] args) {
        // JSON-java 이용해 json 객체 만들고 출력하기

        // 1. student json 객체 만들기
        JSONObject student = new JSONObject();
        student.put("name" , "kildong");
        student.put("phone" , "010-1111-1111");
        student.put("address" , "광주");

        JSONObject student2 = new JSONObject();
        student2.put("name" , "hyunjun");
        student2.put("phone" , "010-1111-1111");
        student2.put("address" , "서울");
        // 2. students json 배열 만들기
        JSONArray studentArr = new JSONArray();
        studentArr.put(student);
        studentArr.put(student2);
        System.out.println(studentArr);
        // 3. object json 객체 만들기
        JSONObject students = new JSONObject();
        students.put("students", studentArr);
        System.out.println(students.toString(2));
    }
}
