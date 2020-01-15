package CodesquadCS.Algorithm;

import java.util.Arrays;

public class NumberOfKth {
    public int[] solution(int[] array, int[][] commands) {
        int[] answerList = makeAnswerList(commands);
        for (int i = 0; i < commands.length; i++) {
            int[] indexModifiedCommand = commandIndexModify(commands[i]);
            int[] slicedArr = sliceArr(array,indexModifiedCommand);
            int[] sortedArr = sortArr(slicedArr);
            int numberOfKth = getNumberOfKth(sortedArr, indexModifiedCommand);
            answerList[i] = numberOfKth;
        }
        return answerList;
    }

    public int getNumberOfKth(int[] sortedArr, int[] indexModifiedCommand) {
        int Kth = indexModifiedCommand[2];
        int numberOfKth = sortedArr[Kth-1];
        return numberOfKth;
    }

    public int[] sortArr(int[] slicedArr) {
        Arrays.sort(slicedArr);
        return slicedArr;
    }

    public int[] sliceArr(int[] array, int[] indexModifiedCommand) {
        int start = indexModifiedCommand[0];
        int end = indexModifiedCommand[1];
        int[] slicedArr = Arrays.copyOfRange(array, start, end);
        return slicedArr;
    }

    public int[] commandIndexModify(int[] command) {
        int[] indexModifiedCommand = new int[3];
        int start = command[0] - 1;
        int end = command[1];
        int pickNumber = command[2];
        indexModifiedCommand[0] = start;
        indexModifiedCommand[1] = end;
        indexModifiedCommand[2] = pickNumber;
        return indexModifiedCommand;
    }

    public int[] makeAnswerList(int[][] commands) {
        int[] answerList = new int[commands.length];
        return answerList;
    }


}


