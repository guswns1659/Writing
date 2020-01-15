package CodesquadCS.Algorithm.QuickSort;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
        printArray(array);
        quickSort(array, 0, array.length - 1);
        printArray(array);
    }

    public static void quickSort(int[] array, int start, int end) {
        int part2 = partition(array, start, end);
        if (start < part2 -1) {
            quickSort(array, start, part2 -1);
        }
        if (part2 < end) {
            quickSort(array, part2, end);
        }
    }

    public static int partition(int[] array, int start, int end) {
        int pivot = array[(start + end) / 2];
        while (start <= end) {
            while (array[start] < pivot) start++;
            while (array[end] > pivot) end--;
            if(start <= end) {
                swap(array, start, end);
                start++;
                end--;
            }
        }
        return start;
    }
    public static void swap(int[] array, int start, int end) {
        int temp = array[start];
        array[start] = array[end];
        array[end] = temp;
    }
    public static void printArray(int[] array) {
        for (int data : array) {
            System.out.print(data + ", ");
        }
        System.out.println();
    }
}
