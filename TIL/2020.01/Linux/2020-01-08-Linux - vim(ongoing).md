## 목차
- Vim 명령어
- Vim 설정하기 

## 핵심
- **꾸준함이 살 길**

## Vim 설정하기 
- 터미널을 띄운다.(Ctrl + Alt + T)

- $ sudo apt-get update 엔터

- $ sudo apt-get install vim 엔터

- vim ~/.vimrc (vim 설정 파일. 하이라이팅, 인덱스, 공백 칸 수등 설정을 할 수 있다.)

- 아래 설정 내용을 입력하고 저장한다.

set number            " 줄 번호 표시

set tabstop=4         " tab을 4칸으로

set ignorecase      " 검색시 대소문자 구별하지 않음

set hlsearch         " 검색시 하이라이트

set fileencodings=utf-8,euc-kr    " 파일인코딩 형식

set bs=indent,eol,start    " backspace 키 사용

set ruler              " 상태표시줄 커서 위치 표시

set title               " 제목 표시

set showmatch    " 매칭되는 괄호 표시

set nowrap         " 자동 줄바꿈 해제

set wmnu           " tab 자동완성시 가능한 목록 표시

syntax on        " 문법 하이라이트

출처: https://ledgku.tistory.com/23 [견우와 직녀]




## vim 명령어 
:w[rite] 저장   // :(콜론)을 누른 다음에 w를 입력한 것입니다. :w # 처럼 숫자(#는 숫자입력을 표시)에 해당하는 파일 이름을 저장할 수 있다. 

:sav[eas] #  // #(숫자를 의미)에 해당하는 파일을 '다른 이름'으로 저장한다.  

:w file.txt   // file.txt 파일로 저장

:w » file.txt   // file.tx파일에 덧붙여서 저장

:q  // vi 종료

:up  // 바뀐 내용만 저장합니다.

:x  // :upq와 같은 내용입니다.

:q! // vi 강제 종료

ZZ // 저장 후 종료

:wq! // 강제 저장 후 종료

:e file.txt file.txt파일을 불러옴

:e 현재 파일을 불러옴

:e# 바로 이전에 열었던 파일을 불러 옴

