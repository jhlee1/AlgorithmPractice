package hackerrank.three_month_interview_prep_kit.week_3.drawing_book;

import java.io.*;

class Result {

    /*
     * Complete the 'pageCount' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER p
     */

    public static int pageCount(int n, int p) {
        // Write your code here
        int fromBack = 0;
        int fromFront = 0;

        fromFront = (p - 1) / 2;
        if (p % 2 == 0) {
            fromFront++;
        }

        fromBack = (n - p) / 2;

        if (n % 2 == 0 && p % 2 != 0) {
            fromBack++;
        }


        return Math.min(fromBack, fromFront);

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        int p = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.pageCount(n, p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
