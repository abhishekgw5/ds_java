package sortingAndsearching;

import java.util.Arrays;

public class mergesort {

    public static int[] merge_sort(int arr[]) {
        if (arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;

        int[] left = merge_sort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = merge_sort(Arrays.copyOfRange(arr, mid, arr.length));
        return merge(left, right);
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int[] mix = new int[arr1.length + arr2.length];
        int i = 0, j = 0, k = 0;

        while (i < arr1.length && j < arr2.length) {
            if (arr1[i] < arr2[j]) {
                mix[k] = arr1[i];
                i++;
            } else {
                mix[k] = arr2[j];
                j++;
            }
            k++;
        }

        if (i < arr1.length) {
            mix[k] = arr1[i];
            i++;
            k++;
        }

        if (j < arr2.length) {
            mix[k] = arr2[j];
            j++;
            k++;
        }

        return mix;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 7, 4, 9, 1 };
        int arr2[] = merge_sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr2[i] + " ");
        }

    }}