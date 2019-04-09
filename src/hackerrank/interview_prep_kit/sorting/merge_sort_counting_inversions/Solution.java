package hackerrank.interview_prep_kit.sorting.merge_sort_counting_inversions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the countInversions function below.
    static long countInversions(int[] arr) {
        return mergeSort(arr, new int[arr.length], 0, arr.length - 1);
    }

    private static long mergeSort(int[] arr, int[] temp, int leftStart, int rightEnd) {
        if(leftStart >= rightEnd) {
            return 0;
        }

        int middle = (leftStart + rightEnd) / 2;

        return mergeSort(arr, temp, leftStart, middle) + mergeSort(arr, temp,middle + 1, rightEnd) + merge(arr, temp, leftStart, rightEnd);
    }

    private static long merge(int[] arr, int[] temp, int leftStart, int rightEnd) {
        long swaps = 0;
        final int leftEnd = (rightEnd + leftStart) / 2;
        int leftIndex = leftStart;
        int rightIndex = leftEnd + 1;
        int tempIndex = leftStart;

        while(leftIndex <= leftEnd && rightIndex <= rightEnd) {
            if(arr[leftIndex] <= arr[rightIndex]) {
                temp[tempIndex] = arr[leftIndex];
                leftIndex++;
            } else {
                temp[tempIndex] = arr[rightIndex];
                rightIndex++;
                swaps += leftEnd - leftIndex + 1;
            }
            tempIndex++;
        }

        System.arraycopy(arr, leftIndex, temp, tempIndex, leftEnd - leftIndex + 1);
        System.arraycopy(arr, rightIndex, temp, tempIndex, rightEnd - rightIndex + 1);
        System.arraycopy(temp, leftStart, arr, leftStart, rightEnd - leftStart + 1);

        return swaps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = countInversions(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
