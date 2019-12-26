출처 : [KOCW ~~]()

## 목차

## 핵심
- **핵심**

## N-Queens 문제
N x N 체스판에서 N개의 퀸을 놓아야 한다. 조건은 퀸끼리는 같은 행, 열, 대각선에 놓이면 안된다. 모든 조건을 만족하며 퀸을 놓을 수 있는지 물어보는 문제이다.<br>
이 문제는 상태조건트리라는 기법으로 풀이를 할 수 있다. 트리 형태로 만들어서 루트 노드부터 하나씩 노드를 방문하며 답을 구하는 기법이다. 이 때 깊이우선탐색 알고리즘을 활용할 수 있다고 한다.<br>
또한, 풀이 과정 중 과거 놓았던 퀸을 번복해야 하는 상황도 발생하기 때문에 **Backtracking** 기법이라고도 한다. Backtracking 기법은 재귀적으로 구현하거나 스택을 활용할 수 있다. 직관적인 방법은 재귀적인 방법이다.

## Design Backtracking recursively
대부분의 Backtracking에 적용할 수 있는 psudocode이다. 참고하자.<br>
```java
return-type queens(arguments) { // arguments가 들어오는 순간 어떤 노드에 도착한 순간
    if non-promising
        report failure and return;
    else if success
        report answer and return;
    else
        visit children recursively;
}
```

## Psudocode
