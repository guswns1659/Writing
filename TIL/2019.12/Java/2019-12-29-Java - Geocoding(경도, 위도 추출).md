## 목차
- Geocoding이란
- 위도, 경도 추출하는 실습(Geocoding)
- 전체 코드
## 핵심
- **Geocoding이란 주소를 입력하면 위도와 경도를 얻는 코딩을 말한다.**

## Geocoding이란?
Geocoding이란 주소를 입력하면 위도와 경도를 얻는 코딩을 말한다. 위도와 경도를 얻기 위해선 위도와 경도를 제공하는 웹사이트에 요청을 해야 한다.<br>
**요청 시에 필요한 정보가**
- 요청하는 웹사이트 URL
- client ID : 웹사이트에서 나를 식별하는 ID
- client secret : Password

## 위도, 경도 추출하는 실습(Geocoding)
- API URL 가져오기 : 가이드 -> API참조서 -> AI.Naver -> Geocoding
- BufferedReader : String 정보를 읽어 온다.
- InputStreamReader : 사용자에게 입력 받은 값은 byte이기에 BufferedReader가 읽을 수 있게 도와주는 객체
### HttpURLConnection : 웹사이트(서버)와 프로그램을 연결 시켜주는 객체
<br>
```java
HttpURLConnection con = (HttpURLConnection) url.openConnection();
con.setRequestMethod("GET");
con.setRequestProperty("X-NCP-APIGW-API-KEY-ID", client_id);
con.setRequestProperty("X-NCP-APIGW-API-KEY", client_secret);
```
### 서버에서 보낸 코드 한 줄씩 읽는 코드
```java
String line;
StringBuffer response = new StringBuffer();
while ((line = br.readLine())!=null) {
    response.append(line);
}
```

## 전체 코드 주소
[전체 코드는 여기로](https://github.com/guswns1659/Writing/blob/master/TIL/TPC2/Project01_D.java)