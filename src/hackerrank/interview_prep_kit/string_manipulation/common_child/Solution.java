package hackerrank.interview_prep_kit.string_manipulation.common_child;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // I understood the concepts but Can't optimize it ....
    // I don't need clone, and use getMax in the return, but I messed up with storing the final result in variables.
    // I also got confused keeping the last state of results variable
    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {
        char[] first = s1.toCharArray();
        char[] second = s2.toCharArray();
        int[] results = new int[second.length];

        for (int i = 0; i < first.length; i++) {
            int[] preResults = results.clone();
            for(int j = 0; j < second.length; j++) {
                if(first[i] == second[j]) {
                    int max = getMax(preResults, j);

                    results[j] = max + 1;
                }
            }
        }

        return getMax(results, results.length);
    }

    private static int getMax(int[] nums, int to) {
        int max = 0;
        for (int i = 0; i < to; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }

        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int result = commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
