[KOCW 부경대학교 권오흠 교수 알고리즘 강의 참고](http://www.kocw.net/home/search/kemView.do?kemId=1148815)

## 목차
- Counting cells in a blob
- 입력과 출력
- 문제에 대한 재귀적 사고
## 핵심
- **연습! 연습!**

## Counting cells in a blob
이 문제는 2차원 그리드에서 하나의 좌표가 주어지면 그 좌표를 포함하고 있는 blob이 몇 개의 픽셀로 이루어져 있는지 리턴하는 문제다. 만약 blob에 속해져 있지 않은 좌표라면 0을 리턴한다.<br>
[Blob 이미지 참조](https://new93helloworld.tistory.com/100)<br>

### 입력과 출력
- 입력
    - N * N 크기의 2차원 그리드
    - 하나의 좌표 (x, y)
- 출력
    - 픽셀 (x,y)가 포함된 blob의 크기
    - (x,y)가 어떤 blob에도 속하지 않은 경우에는 0

### 문제에 대한 재귀적 사고
현재 픽셀이 속한 blob의 크기를 카운트 하려면
- 현재 픽셀이 image color가 아니면
    - 0을 반환한다.
- 현재 픽셀이 image color라면
    - count에 1을 더한다.
    - 현재 픽셀을 빨간색으로 칠한다. (이미 카운트했다는 표시)
    - 인접한 8개의 픽셀에 대해서 그 픽셀이 속한 blob의 크기를 카운트한다.
    -카운터를 반환한다.

### 실제 코드
[실제 코드는 여기로](https://github.com/guswns1659/Writing/blob/master/TIL/kr/Algorithm/CountingBlob.java)