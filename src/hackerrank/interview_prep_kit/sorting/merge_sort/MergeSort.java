package hackerrank.interview_prep_kit.sorting.merge_sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class MergeSort {

    public static void main (String[] args) {
        int[] arr = {1,4,5,2,3};

        mergeSort(arr, 0, arr.length - 1, new int[arr.length]);

        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }

    public static void mergeSort(int[] arr, int leftStart, int rightEnd, int[] temp) {
        if(leftStart >= rightEnd) {
            return;
        }

        int middlePoint = (leftStart + rightEnd) / 2;

        mergeSort(arr, leftStart, middlePoint, temp);
        mergeSort(arr, middlePoint + 1, rightEnd, temp);
        merge(arr, leftStart, rightEnd, temp);

    }

    private static void merge(int[] arr, int leftStart, int rightEnd, int[] temp) {
        int leftEnd = (leftStart + rightEnd) / 2;
        int rightStart = leftEnd + 1;
        int leftIndex = leftStart;
        int rightIndex = rightStart;
        int currentAt = leftStart;

        while(leftIndex <= leftEnd && rightIndex <= rightEnd) {
            if (arr[leftIndex] <= arr[rightIndex]) {
                temp[currentAt] = arr[leftIndex];
                leftIndex++;
            } else {
                temp[currentAt] = arr[rightIndex];
                rightIndex++;
            }
            currentAt++;

        }

        System.arraycopy(arr, leftIndex, temp, currentAt, leftEnd - leftIndex + 1);
        System.arraycopy(arr, rightIndex, temp, currentAt,  rightEnd - rightIndex + 1);
        System.arraycopy(temp, leftStart, arr, leftStart, rightEnd - leftStart + 1);
    }
}
