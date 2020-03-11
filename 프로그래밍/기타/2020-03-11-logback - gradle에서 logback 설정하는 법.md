처음 자바 개발 공부를 시작하면 프로그램이 잘 돌아가나 확인하기 위해 System.out.println()으로 확인한다. 하지만 프로그램을 배포해야 하면 System.out.println()을 다 지워야 한다. 여간 귀찮은 일이 아니라고 한다. 이런 불편함을 해결하기 위해 log 라이브러리가 존재한다. 오늘은 gradle에서 logback 설정해보자. 

LogBack 
## 추상화된 API는 SLF4j, 구현 프레임워크는 LogBack. 둘 다 의존성 추가 해야함.
## resouce폴더 밑에 logback.xml 파일 추가.
## 클래스 내 log code 추가.
