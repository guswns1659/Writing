package index;

// 입력 받은 주소를 네이버API에서 가져와 위치 정보를 출력하는 프로그램
/*
curl "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query={주소}&coordinate=#{검색_중심_좌표}" \
	-H "X-NCP-APIGW-API-KEY-ID: {애플리케이션 등록 시 발급받은 client id값}" \
	-H "X-NCP-APIGW-API-KEY: {애플리케이션 등록 시 발급받은 client secret값}" -v
    ishvyx2tqn
    hjhFUni1JcCIx2H0Bqjc8u66vbVpHqGoDjD8MLm2
 */

import org.json.JSONArray;
import org.json.JSONObject;

public class index {
    public static void main(String[] args) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name" , "gildong");
        jsonObject.put("address" , "광주");

        JSONArray arr = new JSONArray();
        arr.put(jsonObject);
        for (int i = 0; i < arr.length(); i++) {
            JSONObject obj = arr.getJSONObject(i);
            Object string = obj.get("address");
            System.out.println(string.toString());
        }
    }
}
