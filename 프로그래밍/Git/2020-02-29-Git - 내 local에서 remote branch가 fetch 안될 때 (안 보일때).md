# 분명 push했는데 remote branch가 안보여!
혼자서 Git으로 버전관리할 때가 있다. 그런데 종종 나는 분명히 push했는데 local에서 remote 브랜치가 안 보일 때가 있다. 보통 fetch가 안되는 문제인데, 이 때는 git 설정을 변경해줘야 한다. 

## 들어가기 앞서, fetch란? 
fetch란 원격저장소의 변경사항을 새로고침해서 로컬저장소에 보여주는 명령이다. 보여주기만 할 뿐 실제 반영된 것은 아니다. merge 명령을 통해 반영을 해야 한다. 우리가 자주 쓰는 git pull 명령은 git fetch + git merge를 합친 명령이다.

## 해결방법 : git config를 바꾼다.

push가 정상적으로 됐다면 사진처럼 origin/step3가 표시되어야 한다. 하지만 종종 origin 브랜치가 안뜨는 경우가 있다. <br>
[##_Image|kage@vlwYO/btqCpQflGf8/4SKfzMXNwRSJ2M1nZMkKc1/img.png|alignCenter|width="100%"|_##] <br>
origin 브랜치가 안 뜰 땐 현재 git 저장소로 가서 `vim .git/config`를 입력한다. 그럼 아래 사진 처럼 config가 보인다. 

[##_Image|kage@ctblYm/btqCly03fea/cUgtYgtj4mkkkKEXeDjiJk/img.png|alignCenter|width="100%"|_##] <br>

## 설정 변경 방법 

[remote "origin"]
    url = …
    fetch = +refs/heads/master:refs/remotes/origin/master
    
위 설정을 아래 같이 변경 <br> 

[remote "origin"]
    url = …
    fetch = +refs/heads/\*:refs/remotes/origin/\* <br>

**설정 완료 한 후 명령으로 반영할 origin 브랜치를 fetch한다.** <br>

git fetch origin step2 // stpe2 브랜치만 fetch하겠다는 의미. 


## 주의사항 
다만, 설정 변경 후 아래처럼 명령을 입력할 경우 저장소와 연결된 모든 브랜치를 모두 fetch함. 즉, 저장소가 지저분해진다. <br>

git fetch 
