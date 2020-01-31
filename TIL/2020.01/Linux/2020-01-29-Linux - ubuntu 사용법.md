## 한글 설정 
- language support에 들어가서 자동으로 필요한 파일을 다운 받는다. 
- region & language에 들어가서 input sources에 korean(Hangul)을 추가한다. 
- keyboard에 들어가서 switch to next input source에서 한/영 키로 변경한다.

## 마우스 오른쪽 클릭 안될 때 
- 우분투의 기본 설정은 터치 패드에 두 손가락으로 클릭하면 된다. 
- 오른쪽 클릭이 작동하기 위해선 software center에서 GNOME Tweaks를 설치한다. 
- Keyboard & Mouse -> Mouse Click Emulation -> Area 클릭

## java 설치 및 JAVA_HOME, PATH 지정
[영상 참고: 5분 짜리 영상](https://www.theserverside.com/video/5-steps-for-an-easy-JDK-13-install-on-Ubuntu) 

## locate 활용해서 file 찾는 방법
- sudo apt-get install locate
- sudo updatedb
- locate [fileName

## file 확장자 찾는 법
- file [fileName]