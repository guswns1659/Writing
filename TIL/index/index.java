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
import org.json.JSONTokener;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class index {
    public static void main(String[] args) {
        // 1. 요청할 API 주소 및 clinet id, serect 변수 설정
        String apiUrl = "https://naveropenapi.apigw.ntruss.com/map-geocode/v2/geocode?query=";
        String clientId = "ishvyx2tqn";
        String clientSecret = "hjhFUni1JcCIx2H0Bqjc8u66vbVpHqGoDjD8MLm2";

        // 2. 사용자에게 입력 받고 요청할 url주소에 붙이는 코드
        InputStreamReader is = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(is);

        try {
            System.out.print("주소를 입력하세요.");
            String address = br.readLine();
            String encodeAddr = URLEncoder.encode(address, "UTF-8");
            String reqUrl = apiUrl + encodeAddr;

            // 3. API와 연결할 준비
            URL url = new URL(reqUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", clientId);
            con.setRequestProperty("X-NCP-APIGW-API-KEY", clientSecret);

            // 4. 입력이 성공적이라면 서버가 보낸 정보 읽기
            int responCode = con.getResponseCode();
            BufferedReader br2;
            if (responCode == 200) {
                br2 = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
                System.out.println(br2);
            } else {
                br2 = new BufferedReader(new InputStreamReader(con.getErrorStream()));
            }

            // 5. 서버가 보낸 정보 한 줄씩 읽어오기
            String line = "";
            StringBuffer respon = new StringBuffer();
            while ((line=br2.readLine()) != null){
                respon.append(line);
            }
            br2.close();

            // 6. 한 줄씩 읽어온 파일 json 형태로 만들기
            JSONTokener jsonTokener = new JSONTokener(respon.toString());
            JSONObject object = new JSONObject(jsonTokener);
            JSONArray arr = object.getJSONArray("addresses");
            for (int i = 0; i < arr.length(); i++) {
                JSONObject addrInfo = arr.getJSONObject(i);
                System.out.println(addrInfo.get("roadAddress"));
                System.out.println(addrInfo.get("jibunAddress"));
                System.out.println(addrInfo.get("x"));
                System.out.println(addrInfo.get("y"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
