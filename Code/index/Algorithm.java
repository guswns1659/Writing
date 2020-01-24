package index;

public class Algorithm {
    public static void main(String[] args) {

    }
    //이진 탐색
    public static int binarySearch(String[] items, String target, int begin, int end) {
        if (begin > end) return -1; // 길이가 0인 경우
        else {
            int middle = (begin + end) / 2;
            int compResult = target.compareTo(items[middle]);
            if (compResult == 0) return middle;
            else if (compResult < 0) return binarySearch(items, target, begin, middle-1);
            else return binarySearch(items, target, middle+1, end);
        }
    }
}