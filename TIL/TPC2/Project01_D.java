package TPC2;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

public class Project01_D {
    public static void main(String[] args) {
        // 1. API Url과 client_id, client_secret 변수로 저장
        String apiURL = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query=";
        String client_id = "ishvyx2tqn";
        String client_secret = "hjhFUni1JcCIx2H0Bqjc8u66vbVpHqGoDjD8MLm2";

        // 2. 사용자에게 주소 값 입력 받는 코드
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader io = new BufferedReader(is);
        try {
            System.out.print("주소를 입력하세요.");
            String address = io.readLine();
            String addr = URLEncoder.encode(address, "UTF-8");
            String reqUrl = apiURL + addr;
        // 3.  정확한 URL인지 검사 및 주소 값을 가지고 연결 URL 만들기
            URL url = new URL(reqUrl); // URL이 정확하지 않으면 에러 발생
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", client_id);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", client_secret);
        // 4. 서버와 연결 확인 및 서버에서 보낸 정보 읽어오기
            BufferedReader br; // 서버와 Stream(통로)가 만들어짐.
            int responseCode = con.getResponseCode();
            if (responseCode == 200) {
                br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            } else {
                br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }
        // 5. 서버에서 보낸 정보 한 줄씩 읽어서 JSON으로 저장
            String line;
            StringBuffer response = new StringBuffer();
            while ((line = br.readLine())!=null) {
                response.append(line);
            }
            br.close();
        // 6. Json 파일에서 경도, 위도 정보 추출하기.
            JSONTokener jsonTokener = new JSONTokener(response.toString());
            JSONObject object = new JSONObject(jsonTokener);
            JSONArray arr = object.getJSONArray("addresses");
            for (int i = 0; i < arr.length(); i++) {
                JSONObject addressInfo = arr.getJSONObject(i);
                System.out.printf("address : %s\n", addressInfo.get("roadAddress"));
                System.out.printf("지번 : %s\n", addressInfo.get("jibunAddress"));
                System.out.printf("경도 : %s\n", addressInfo.get("x"));
                System.out.printf("위도 : %s\n", addressInfo.get("y"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}
