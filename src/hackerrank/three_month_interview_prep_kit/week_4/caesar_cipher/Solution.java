package hackerrank.three_month_interview_prep_kit.week_4.caesar_cipher;

import java.io.*;

class Result {

    /*
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
        int range = 'a' - 'z' - 1;
        char[] result = new char[s.length()];
        int resultIndex = 0;

        for (char c : s.toCharArray()) {
            char converted = 0;
            if (c >= 'A' && c <= 'Z') {
                converted = (char) (((c - 'A') + k) % range + 'A');
            } else if (c >= 'a' && c <= 'z') {
                converted = (char) (((c - 'a') + k) % range + 'a');
            } else {
                converted = c;
            }

            result[resultIndex] = converted;
            resultIndex++;
        }

        return String.copyValueOf(result);


    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

