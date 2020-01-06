## 목차
- Mission1 : 가상머신 리눅스 설치 및 SSH 연결
- Mission2 : 쉘스크립트
## 핵심
- **Shell script은 리눅스를 제어하는 언어이다.** 

## Mission1 : 가상머신 리눅스 설치 및 SSH 연결
### 1. 가상머신이란
- 하드웨어를 소프트웨어로 구현하는 프로그램을 말한다. 실제 하드웨어는 아니고 소프트웨어 위에 OS를 설치할 수 있다.
- 왜 사용할까?
    - 다른 운영 체제를 사용해야 하는 경우가 대표적이다.

### 2. 가상머신 및 우분투 설치
- 가상머신 및 우분투 설치 환경 확인 : grc.com/securable.htm 설치 후 확인한다.
- [VirtualBox 다운로드는 이곳에서](https://www.virtualbox.org/wiki/Downloads)
- [Ubuntu 다운로드는 이곳에서](https://ubuntu.com/download/desktop)
    - LTS(Long Term Support)를 추천한다. 의미대로 오랜 기간 업데이트를 적용받는다. 
    - iso압축파일을 압축해제 하지 않는다. 그 자체로 CD의 역할을 하는 것이다. 

### 3. 가상머신 위에 우분투 설치
이제 가상머신 위에 우분투 OS를 설치해보자. 우리가 원래 OS를 설치할 때 기억을 더듬어 보면 CD를 이용해서 설치한다. 우리가 다운받은 iso이미지 파일은 우분투를 설치할 수 있는 프로그램이 하나의 이미지처럼 저장되어 있는 상태를 말한다. 즉, iso이미지 파일이면 마치 CD를 넣은 것처럼 우분투를 설치할 수 있다. 
- **하드 디스크 파일 종류는 VDI (VirtualBox 디스크 이미지) 를 선택한다.** 
- **드라이브 크기는 동적 할당으로 한다.** 미리 크기를 설정하면 Host computer도 그 크기만큼 항상 저장공간을 빼놓아야 한다. 차라리 가상 머신이 작동할 때마다 드라이브 용량을 사용하는 것이 합리적이다. 물론 속도르 느릴 수 있다.  

### 4. SSH란
이제 가상 환경 설치를 완료했다. 그런데 대부분 개발 환경은 서버와 작업 공간이 분리되어 있다. 그래서 작업 공간에서 설계를 한 뒤 원격으로 서버에 배포하는 형식이다. 즉, 로컬 컴퓨터에서 원격 컴퓨터를 컨트롤할 수 있어야 한다. 이를 위해 원격 접속이 필요하다.<br>
원격 접속을 이용하여 터미널 환경을 사용할 수 있도록 고안된 프로토콜이 Telnet, SSH이다. 원격지로 연결을 가능 하도록 하는 네트워크 접속 도구이다. **그런데 왜 SSH를 사용해야 할까?**<br>
Telnet보다 암호화된 통신을 가능하게 한다. 더 안전하다. 예를 들어, 문자열을 식별 불가능한 문자로 바꿔서 출력한다. 이에 반해 Telnet은 문자열 그대로 출력한다.

### 5. 가상 환경에 SSH Server 설치 
가상 환경을 로컬 컴퓨터에서 컨트롤하려면 가상 환경에 SSH server를 설치해야 한다.
<br>

```shell script
sudo apt-get install openssh-server openssh-client
```
<br>

SSH server 설치가 완료되면 SSH를 실행한 뒤 작동하는 지 확인 한다. 
<br>

```shell script
sudo service ssh start // 실행
sudo ps aux | grep ssh // 정상 작동하면 ssh라고 적혀있다. 
``` 
<br>

이제 로컬컴퓨터에서 가상 환경으로 연결할 준비를 한다. 이 때 window 사용자는 git bash를 사용하면 된다. git bash에 들어가서 아래 코드를 입력한다.  
<br>

```shell script
ssh <사용자이름>@가상환경ip 
ssh jun@127.0.0.1 
```
<br>
성공적으로 연결됐다면 backup 디렉토리를 764모드로 변경한다. 아래 코드 
<br>

```shell script
chmod -R 764 backup
```

## Mission2 : 쉘스크립트 
### 1. shell과 kernel
shell은 껍데기, kernel은 핵심이라는 의미이다. 커널은 컴퓨터 하드웨어(cpu, memory 등)을 조작하는 기능을 한다. 하드웨어를 감싸고 있는 커널. 그리고 그 커널에게 사용자의 명령을 전달하는 shell이 있다. 쉘은 커널을 껍데기처럼 감싸고 있다. 마치 컴파일러랑 비슷하다.<br>
사용자가 shell에게 명령하면 shell은 그 명령을 kernel이 이해할 수 있게 변환한다. 그 뒤 kernel은 사용자의 명령을 하드웨어에게 시킨다.<br>
**그럼 shell과 kernel은 왜 나눠져 있을까?** 사용자가 원하는 shell을 선택해서 사용할 수 있게 하는 것이 아닐까? shell의 종류는 여러 가지가 있다. 자신에게 맞는 shell을 사용하면 된다.

### 2. Shell Script
script의 의미는 연극의 대본이다. 배우들의 대사 순서가 적혀있다. 그래서 대본대로 연극은 진행된다. 이처럼 프로그램도 명령이 일련의 순서로 이루어지기 때문에 script와 비슷하다. shell도 script가 있어서 자동화된 업무를 쉽게 처리할 수 있다.

### 3. 실습
실습의 요구 사항은 하나의 디렉토리에 들어있는 day1~16 디렉토리를 순회한다. 그 뒤 각 디렉토리에 확장자 `.cs`파일을 압축한 뒤 백업한다. 백업한 파일을 가상 환경에 옮긴다. 

**피드백 : 나는 SSH 설치까지 했고 스크립트 실습은 JK의 동영상을 참고했다.**<br>

#### 구현 과정
- 기능은 3가지로 나눈다. : 순회 -> 압축 -> 가상환경에 복사 
    - travel_dir : 먼저 디렉토리를 순회하고 `.cs`파일을 배열에 넣는 함수를 구현한다. 
    - zip_files : 배열에 있는 `.cs`파일을 하나로 압축한다. 
    - copy_toserver : 백업 파일을 가상 환경에 복사한다. 

#### 구현 실패 요소 
- 백업 파일을 가상 환경에 복사 실패 : `/backup Is a Directroy` 발생.


```shell script
#!/bin/bash

current_dir=$(pwd)
echo "current_dir : $current_dir"

files=()
filename=""

function travel_dir {
    for d in */ ; do
      for f in $d*.cs ; do
        if [[ $f != "$d*.cs" ]] ; then
          echo "$f"
          files+=($f)
        else
          echo ">>> Empty Directory : $d"
        fi
      done
    done
}

function zip_files {
    FILEDATE=$(date +%Y%m%d)
    filename="backup_$FILEDATE.zip"
    for file in "${files[@]}"
    do
      echo $file
      zip $filename $file
    done
}

function copy_toserver {
  x="/backup/"
  scp $filename guswns1659@127.0.0.1:x
}

travel_dir
zip_files
copy_toserver
``` 