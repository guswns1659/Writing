## 목차
- Json-java(org.json) 사용법
- json 파일 읽어서 값 추출하는 실습
## 핵심
- **JSON-java API를 사용하면 객체를 바로 만들어 사용할 수 있다.**

## Json-java(org.json) 사용법
json을 만드는 다른 API이다. Gson과 다른 점은 객체를 바로 만들어서 사용할 수 있다. JSONObject라는 객체가 json형태로 객체를 생성한다.<br>
```java
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
```


## json 파일 읽어서 값 추출하는 실습
```java
    // 1. json 파일에서 json 데이터 불러오기
    String src = "info.json";
    InputStream is = Project01_C.class.getResourceAsStream(src);
    if (is == null) {
        throw new NullPointerException("Cannot find resource file");
    }
    // 2. 읽어온 json 데이터를 메모리에 로딩하기  : JSONTokener 객체 사용
    JSONTokener tokener = new JSONTokener(is);

    // 3. JSONTokener 객체를 JSONObject 객체로 만들기
    JSONObject object = new JSONObject(tokener);

    // 4. Json 객체에 있던 jsonArray 꺼내기
    JSONArray students = object.getJSONArray("students");

    // 5. jsonArray 안에 있는 student 객체 출력하기.
    for (int i = 0; i < students.length(); i++) {
        JSONObject student = students.getJSONObject(i);
        System.out.println(student.get("address"));
    }    
```