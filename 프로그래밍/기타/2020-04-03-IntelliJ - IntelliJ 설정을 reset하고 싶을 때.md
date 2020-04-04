## 1.개요 
- 마크다운에 글을 입력하닥 종종 숫자 다음에 개행되는 버그?가 발생했다. 어떤 설정인지 몰라서 지울 수도 없는 상황에 아예 설정을 reset하자는 결론은 내리고 찾아본 방법들.
- 아래처럼 개행이 자동으로 된다. 

```
안녕하세요 오늘은 3
번째 강의입니다. 
```

## 2. 방법 
### 2.1 IntelliJ 끈 상태에서 config 파일을 지운다. 
- [참고 https://intellij-support.jetbrains.com/hc/en-us/community/posts/207006735-Reset-IntelliJ-settings-to-default-](https://intellij-support.jetbrains.com/hc/en-us/community/posts/207006735-Reset-IntelliJ-settings-to-default-)
- 터미널에 홈디렉토리로 들어간다. -> ls -al로 /.IntelliJIdea2019.03과 비슷한 폴더를 찾는다. -> 들어가서 config 파일을 지운다. 

```shell script
cd ~/.IntelliJIdea2019.03 // 이름은 다를 수 있다. 
rm -rf config // 설정 파일 삭제
```

- 만약, 홈디렉토리에 /.IntelliJIdea2019.03같은 디렉토리가 없다면 위에 참고URL을 들어가서 다른 조언을 찾는다. 

### 2.2 config 파일을 지우면 설정이 초기화되서 IntelliJ가 다시 시작한다. 
