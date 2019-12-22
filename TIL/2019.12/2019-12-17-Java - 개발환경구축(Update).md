# 개발 환경 구축 
혼자 개발 환경 구축을 할 수 있을 정도로 연습한다. 나중에 개발환경 문제가 생기더라도 대처가 가능하다. 

## 시리즈
- javaSE : Standard Edition으로 기본적인 개발 가능.
- javaEE : 웹 개발 가능.
## 순서 
1. JDK(Java Development Kit)를 설치한다. 
2. 시스템 환경 변수에 JAVA_HOME 만들고 jdk디렉토리 경로 추가, path에 jdk\bin 디렉토리 경로 추가
	* cmd에서 `java -version` 명령으로 설치 확인한다.
3. 에디터(eclipse)를 설치한다. 
4. eclipse의 환경을 JRE에서 JDK로 바꿔준다 .
	* windows -> preference -> java -> installed JREs -> JDK 디렉토리를 추가한 뒤 설정 변경
5. 인코딩을 utf-8로 바꿔준다.
	* windows -> preference -> general -> Workspace -> 하단에 Text File Encoding -> others 선택 후 utf-8로 변경

## CMD에서 자바실행
1. cmd에서 자바파일이 있는 디렉토리로 이동
2. `javac.exe HelloWorld.java` 를 통해 컴파일한다 -> 기계어로 바꿔준다.
	* 컴파일하면 HelloWorld.class 파일 생성
3. `java HelloWorld` 명령으로 실행! 

**이클립스는 이 모든 과정을 한번에 도와주는 편리한 도구지만 원리는 이해하고 있어야한다.** 

## Github와 연결하기 
이클립스에서 바로 깃허브와 연결이 가능하다. 나는 이런 순서로 진행했다. 
1. 깃허브 저장소를 만든다. (Java-Playground)
2. 소스트리에 깃허브 저장소를 클론한다. 
3. 클론된 작업 디렉토리로 이클립스를 켠다.
4. 이클립스에서 commit 및 push 한다. 

만약, 이클립스에서 바로 깃과 깃허브랑 연결하길 원한다면 아래 방법으로   

1. 깃 연결 : 이클립스 프로젝트를 우클릭해 Team -> share project 
2. add : Team -> add to index (index는 staging과 동의어)
3. 깃허브 연결 : Team -> push branch 'master'
4. commit : Team -> commit 
   
 ## 디렉토리 하나로 어디서든 개발환경 구축하기
 - 디렉토리 안에 jdk와 이클립스를 설치하고 설치 경로를 추가하면 다른 컴퓨터에서도 사용 가능하다. 
 jdk나 이클립스를 다운로드 받지 않아도 된다는 점.  