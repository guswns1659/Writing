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
- 글 참고 : [https://dev.to/mskian/install-z-shell-oh-my-zsh-on-ubuntu-1804-lts-4cm4](https://dev.to/mskian/install-z-shell-oh-my-zsh-on-ubuntu-1804-lts-4cm4)
- 위 글대로 하되 테마 설정 완료 한 후 [이 글 참고해서 실행하기](https://github.com/ohmyzsh/ohmyzsh/issues/8038)

## oh.my.zsh 테마 설정
- cd ~
- cd .oh-my-zsh/themes 
- vim agnoster.zsh-theme 들어간 뒤 필요한 테마 설정

### agnoster new line 설정하기 

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

## 터미널 프롬프트 설정
- .bashrc:16: command not found: shopt
	- zsh가 기본 설정인데 예전 bashrc를 설정하려고 할 때 나는 에러라고 함. 
	- 참고 : [https://stackoverflow.com/questions/26616003/shopt-command-not-found-in-bashrc-after-shell-updation](https://stackoverflow.com/questions/26616003/shopt-command-not-found-in-bashrc-after-shell-updation)

## 터미널 프롬프트 이름 지우는 방법 
참고 : [https://the-illusionist.me/49](https://the-illusionist.me/49)

- 아래 코드를 vim ~/.zshrc 맨 마지막에 넣고 wq!로 저장한다. 

```shell script
prompt_context() { if [[ "$USER" != "$DEFAULT_USER" || -n "$SSH_CLIENT" ]]; then prompt_segment black default "%(!.%{%F{yellow}%}.)$USER" fi }  
```

- 그 뒤 source ~/.zshrc 실행하면 바로 적용. 

## auto-suggestions 적용하는 법
- 참고 : [https://nachwon.github.io/how-to-install-zsh-plugins/](https://nachwon.github.io/how-to-install-zsh-plugins/)

## FzF 적용하는 법
- 참고 : [https://medium.com/harrythegreat/fzf%EB%A1%9C-zsh-%ED%84%B0%EB%AF%B8%EB%84%90-%EB%8D%94-%EA%B0%95%EB%A0%A5%ED%95%98%EA%B2%8C-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0-730c20eb496b](https://medium.com/harrythegreat/fzf%EB%A1%9C-zsh-%ED%84%B0%EB%AF%B8%EB%84%90-%EB%8D%94-%EA%B0%95%EB%A0%A5%ED%95%98%EA%B2%8C-%EC%82%AC%EC%9A%A9%ED%95%98%EA%B8%B0-730c20eb496b)
- 좋은 기능으로 보이는데 초보인데 벌써 사용하고 싶진 않다. 

## 유용한 zsh 플러그인 6가지.
- 주소 : [https://medium.com/harrythegreat/zsh%EC%99%80-%ED%95%A8%EA%BB%98-%EC%82%AC%EC%9A%A9%ED%95%A0-%ED%94%8C%EB%9F%AC%EA%B7%B8%EC%9D%B8-%EC%B6%94%EC%B2%9C-6%EA%B0%80%EC%A7%80-8f9b8b7f3c24](https://medium.com/harrythegreat/zsh%EC%99%80-%ED%95%A8%EA%BB%98-%EC%82%AC%EC%9A%A9%ED%95%A0-%ED%94%8C%EB%9F%AC%EA%B7%B8%EC%9D%B8-%EC%B6%94%EC%B2%9C-6%EA%B0%80%EC%A7%80-8f9b8b7f3c24)


## Ubuntu에 git 설치하기 
- sudo apt update
- sudo apt install git
- git --version // 버전확인
