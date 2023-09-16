package sortingAndsearching;
import java.util.Set;

public class sorting {
    public static void bubbleSort(int arr[], int start, int end) {
        if (end == 0) {
            return;
        }
        if (start < end) {
            if (arr[start] > arr[start + 1]) {
                int temp = arr[start];
                arr[start] = arr[start + 1];
                arr[start + 1] = temp;
            }
            bubbleSort(arr, start + 1, end);
        }
        bubbleSort(arr, 0, end - 1);
    }

    public static void selectionSort(int arr[], int start, int end, int max) {
        if (end == 0) {
            return;
        }
        if (start < end) {
            if (arr[start] > arr[max]) {
                selectionSort(arr, start + 1, end, start);
            } else {
                selectionSort(arr, start + 1, end, max);
            }
        } else {
            int temp = arr[end - 1];
            arr[end - 1] = arr[max];
            arr[max] = temp;
            selectionSort(arr, 0, end - 1, 0);
        }
    }

    public static void insertionSort(int arr[], int start, int end) {
        //initially start=end=0
        if (end == arr.length) {
            return;
        }
        if (start >= 0) {
            if (arr[end + 1] < arr[start]) {
                int temp1 = arr[end + 1];
                for (int i = start; i <= end; i++) {
                    arr[i + 1] = arr[i];
                }
                arr[start] = temp1;
            } else {
                insertionSort(arr, start - 1, end);
            }
        } else {
            insertionSort(arr, end + 1, end + 1);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 3, 1, 4, 6, 5, 2 };
        // bubbleSort(arr, 0,arr.length-1);
        // selectionSort(arr, 0, arr.length, 0);
        insertionSort(arr, 0, 0);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}



