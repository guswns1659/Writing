## 한글 설정 
- language support에 들어가서 자동으로 필요한 파일을 다운 받는다. 
- region & language에 들어가서 input sources에 korean(Hangul)을 추가한다. 
- keyboard에 들어가서 switch to next input source에서 한/영 키로 변경한다.
### tweak 사용
- Then open GNOME Tweaks (gnome-tweaks).
- Select Keyboard & Mouse tab
- Click Additional Layout Options button
- Expand Switching to another layout
- Select Ctrl + Shift here
[출처 : https://askubuntu.com/questions/1029588/18-04-ctrlshift-to-change-language](https://askubuntu.com/questions/1029588/18-04-ctrlshift-to-change-language)

## 마우스 오른쪽 클릭 안될 때 
- 우분투의 기본 설정은 터치 패드에 두 손가락으로 클릭하면 된다. 
- 오른쪽 클릭이 작동하기 위해선 software center에서 GNOME Tweaks를 설치한다. 
- Keyboard & Mouse -> Mouse Click Emulation -> Area 클릭

## java 설치 및 JAVA_HOME, PATH 지정
[영상 참고: 5분 짜리 영상](https://www.theserverside.com/video/5-steps-for-an-easy-JDK-13-install-on-Ubuntu) 

## file 찾는 방법
- sudo apt-get install locate
- sudo updatedb
- locate [fileName
### whereis 파일명


## file 확장자 찾는 법
- file [fileName]

## Terminal에 oh-my-zsh 추가하기
[https://dev.to/mskian/install-z-shell-oh-my-zsh-on-ubuntu-1804-lts-4cm4](https://dev.to/mskian/install-z-shell-oh-my-zsh-on-ubuntu-1804-lts-4cm4)

## 단축키
Ctrl + Alt + T : 바탕화면에서 터미널을 실행
Ctrl + Shift + T : 터미널내에서 새탭으로 터미널을 실행
Ctrl + Shift + N : 터미널내에서 새로운 터미널을 실행
Ctrl + Shift + W : 탭으로 실행된 터미널을 종료
Ctrl + Shift + Q : 현재 터미널을 종료(탭포함)
Ctrl + Shift + F : 터미널내에 문자열검색
Alt + 숫자 : 탭간에 이동
Ctrl + PageUp/PageDown : 다음/이전 탭으로 이동

