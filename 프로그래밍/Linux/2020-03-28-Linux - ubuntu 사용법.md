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

### Uim 설정 하는 법 
한글 밀리는 거 해결하려고 이것저것 설치하다가 갑자기 한글 자소 구분이 안되서 결국 UIM으로 설치 완료.. 
나중에 정리할 예정 ! 아래 출처
[http://progtrend.blogspot.com/2018/06/ubuntu-1804-uim.html](http://progtrend.blogspot.com/2018/06/ubuntu-1804-uim.html)

## 마우스 오른쪽 클릭 안될 때 
- 우분투의 기본 설정은 터치 패드에 두 손가락으로 클릭하면 된다. 
- 오른쪽 클릭이 작동하기 위해선 software center에서 GNOME Tweaks를 설치한다. 
- Keyboard & Mouse -> Mouse Click Emulation -> Area 클릭

## java 설치 및 JAVA_HOME, PATH 지정
[영상 참고: 5분 짜리 영상](https://www.theserverside.com/video/5-steps-for-an-easy-JDK-13-install-on-Ubuntu) 

- 운영체제에 맞게 jdk8 tar.gz파일을 다운받는다. [여기서 다운](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
- 압축 파일을 푼 후 압축을 푼 파일을 /opt로 이동한다. sudo mv jdk8~~ /opt
- 아래처럼 자바 환경변수를 설정할 shell 파일을 만들고 환경변수 명령을 입력한다 

```shell script
jdk13@ubuntu:$ sudo tee /etc/profile.d/jdk8env.sh <<EOF
export JAVA_HOME=/opt/jdk-1.8.0_241
export PATH=\$PATH\$JAVA_HOME/bin
EOF
```

- source 명령으로 sh파일을 실행한다. 

```shell script
$ source /etc/profile.d/jdk8env.sh
```

- 잘 지정됐는지 확인한다. 

```shell script
echo $JAVA_HOME
echo $PATH
```

- java -version 입력하면 jdk 없다고 하는데 intelliJ에서 프로젝트 구조에서 jdk 직접 설정하면 된다. 

## file 찾는 방법
- sudo apt-get install locate
- sudo updatedb
- locate [fileName
### whereis 파일명


## file 확장자 찾는 법
- file [fileName]

## 단축키
- Ctrl + Alt + T : 바탕화면에서 터미널을 실행
- Ctrl + Shift + T : 터미널내에서 새탭으로 터미널을 실행
- Ctrl + Shift + N : 터미널내에서 새로운 터미널을 실행
- Ctrl + Shift + W : 탭으로 실행된 터미널을 종료
- Ctrl + Shift + Q : 현재 터미널을 종료(탭포함)
- Ctrl + Shift + F : 터미널내에 문자열검색
- Alt + 숫자 : 탭간에 이동
- Ctrl + PageUp/PageDown : 다음/이전 탭으로 이동

## Terminal에 oh-my-zsh 추가하기
[https://dev.to/mskian/install-z-shell-oh-my-zsh-on-ubuntu-1804-lts-4cm4](https://dev.to/mskian/install-z-shell-oh-my-zsh-on-ubuntu-1804-lts-4cm4)

## oh.my.zsh 테마 설정
- cd ~
- cd .oh-my-zsh/themes 
- vim agnoster.zsh-theme 들어간 뒤 필요한 테마 설정

### agnoster new line 

```shell script
prompt_end() {
  if [[ -n $CURRENT_BG ]]; then
      print -n "%{%k%F{$CURRENT_BG}%}$SEGMENT_SEPARATOR"
  else
      print -n "%{%k%}"
  fi

  print -n "%{%f%}"
  CURRENT_BG='' 

  #Adds the new line and ➜ as the start character.
  printf "\n ➜";
}
```

## Ubuntu에 git 설치하기 
- sudo apt update
- sudo apt install git
- git --version // 버전확인
