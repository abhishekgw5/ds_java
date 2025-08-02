package sortingAndsearching;

public class quickSort {

    static int partition(int[] a, int left, int right) {
        int pivot = right;
        while (left < right) {
            if (a[left] <= a[pivot]) {
                left++;
            }
            if (a[right] > a[pivot]) {
                right--;
            }
            if (left < right) {
                int temp = a[left];
                a[left] = a[right];
                a[right] = temp;
            }
        }
        int temp = a[left];
        a[left] = a[pivot];
        a[pivot] = temp;
        return left;
    }

    static void quicksort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int split = partition(a, low, high);
        quicksort(a, low, split - 1);
        quicksort(a, split + 1, high);
    }

    public static void main(String[] args) {
        int arr[] = { 5,9, 3, 7, 1, 2, 4, };
        quicksort(arr, 0, arr.length - 1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
