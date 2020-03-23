[참고 : https://gmlwjd9405.github.io/2018/05/18/git-stash.html](https://gmlwjd9405.github.io/2018/05/18/git-stash.html)

# 목차
- Git stash란? 
- 어떻게 사용하는가? 

## Git stash란? 
stash의 사전적 의미는 숨겨주다라는 의미다. Git에서는 무엇을 숨겨줄까? 잠시 변경된 파일을 숨겨준다. 이런 상황에 사용할 수 있다. 현재 브랜치에서 코드를 작성하고 있을 때 갑자기 다른 브랜치로 가야할 상황이 있다. 이 때 현재 브랜치의 변경 사항을 커밋해야 변경할 수 있다. 그런데 매번 변경사항을 커밋하는 건 불편한 일이다. 이 때 git stash를 통해 변경 사항을 잠시 숨겨주면 된다. 

## 어떻게 사용하는가? 
stash 가 적용되는 파일은 무엇일까? git tracking 하는 파일들이다. 
- Stage에 올라간 파일 
- Stage에는 없지만 Modified 상태인 파일 

> stash 하는 명령어  

```git
git stash 
git stash save 
```

위 명령을 입력하면 stash에 스택에 쌓인다. 그래서 가장 늦게 push된 stash를 먼저 꺼내는 구조이다. 

> stash list 확인하기 

```git
git stash list
```

> 현재 브랜치에 stash 적용하기

```git
git stash apply 
git stash apply --index // staged된 파일은 stage로 보내주는 옵션
```

> stash  제거하기 

```git 
git stash drop // 가장 최근 stash를 제거한다. 
git stash drop {stash hash값} // 해당하는 stash 제거
git stash pop // stash를 꺼내면서 제거.
```

> stash 되돌리기 

```git
git stash show -p | git apply -R
```
