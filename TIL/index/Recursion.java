package index;

public class Recursion {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30};
        System.out.println(IterLinearSearch(arr, 40));
        System.out.println(RecurLinearSearch(arr, 0, 2, 40));
        String[] strArr = {"I", "Love", "You"};
        String target = "Love!";
        int result = binarySearch(strArr, 0, strArr.length-1, target);
        System.out.println(result);

    }
    // Iterative linear search
    public static int IterLinearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }
    // Recursive linear search
    public static int RecurLinearSearch(int[] arr, int begin, int end, int target) {
        if (begin > end) return -1;
        else {
            if (arr[begin] == target) return begin;
            else {
                return RecurLinearSearch(arr, begin+1, end, target);
            }
        }
    }
    // Recursive find maxvalue
    public static int findMax(int[] arr, int begin, int end) {
        if (begin == end) return arr[begin];
        else {
            return Math.max(arr[begin], findMax(arr, begin+1, end));
        }
    }

    // Recursive binary search
    public static int binarySearch(String[] arr, int begin, int end, String target) {
        if (begin > end) return -1;
        else {
            int middle = (begin + end) / 2;
            int compareResult = target.compareTo(arr[middle]);
            if (compareResult==0) return middle;
            else if (compareResult < 0) return binarySearch(arr, begin, middle-1, target);
            else return binarySearch(arr, middle+1, end, target);
        }
    }
}