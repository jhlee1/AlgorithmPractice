package hackerrank.interview_prep_kit.greedy_algorithms.luck_balance;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
        ArrayList<Integer> importants = new ArrayList<>();
        int result = 0;

        for (int i = 0; i < contests.length; i++) {
            if (contests[i][1] == 0) {
                result += contests[i][0];
            } else {
                importants.add(contests[i][0]);
            }
        }

        importants.sort(Integer::compareTo);
        final int takeFromImportants = importants.size() - k > 0 ? importants.size() - k : 0;

        for(int i = importants.size() - 1; i >= takeFromImportants; i--) {
            result += importants.get(i);
        }

        for(int i = 0; i < takeFromImportants; i++) {
            result -= importants.get(i);
        }

        return  result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output06.txt"));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
