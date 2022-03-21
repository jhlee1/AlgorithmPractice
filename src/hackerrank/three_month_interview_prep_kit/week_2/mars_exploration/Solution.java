package hackerrank.three_month_interview_prep_kit.week_2.mars_exploration;

import java.io.*;

class Result {

    /*
     * Complete the 'marsExploration' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int marsExploration(String s) {
        char[] s_arr = s.toCharArray();
        char[] expected_chars = new char[3];
        int result = 0;

        expected_chars[0] = 'S';
        expected_chars[1] = 'O';
        expected_chars[2] = 'S';

        for (int i = 0; i < s_arr.length; i++) {
            if (s_arr[i] != expected_chars[i % 3]) {
                result++;
            }
        }

        return result;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int result = Result.marsExploration(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
