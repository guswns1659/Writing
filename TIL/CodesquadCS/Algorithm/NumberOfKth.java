package CodesquadCS.Algorithm;

/*
- 2차원 배열에서 원소 꺼내기.
- 원소만큼 배열 자르기
- 자른 배열 정렬하기
- 값 꺼내기
- 나온 값 배열로 넣기
 */

import java.util.Arrays;

public class NumberOfKth {
    public int[] solution(int[] arrry, int[][] commands) {
        int[] answer = {};
        return answer;
    }
    public int[] slice(int[] array, int[][] commands) {
        int sizeOfAnswerArr = commands.length;
        int[] answerArr = new int[sizeOfAnswerArr];
        for (int[] smallArray : commands) {
            int start = smallArray[0]-1;
            int end = smallArray[1]-1;
            int sliceCount = end - start +1;
            int pick = smallArray[2]-1;
            int[] sliceArr = new int[end-start+1];
            for (int i = 0; i < sliceCount; i++) {
                sliceArr[i] = array[start++];
            }
            sort(sliceArr);
            int answer = answer(sliceArr, pick);
        }

        return answerArr;
    }
    public void sort(int[] sliceArr) {
        Arrays.sort(sliceArr);
    }
    public int answer(int[] sliceArr, int pick) {
        int answer = sliceArr[pick];
        return answer;
    }
}
