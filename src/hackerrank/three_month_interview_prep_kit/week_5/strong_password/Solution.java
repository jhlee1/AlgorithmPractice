package hackerrank.three_month_interview_prep_kit.week_5.strong_password;

import java.io.*;

class Result {

    /*
     * Complete the 'minimumNumber' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. STRING password
     */

    public static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        int lengthRequirement = 0;
        int charRequirement = 0;

        if (n < 6) {
            lengthRequirement = 6 - n;
        }

        if (!password.matches(".*[0-9].*")) {
            charRequirement++;
        }

        if (!password.matches(".*[a-z].*")) {
            charRequirement++;
        }

        if (!password.matches(".*[A-Z].*")) {
            charRequirement++;
        }

        if (!password.matches(".*[!@#$%^&*()+-].*")) {
            charRequirement++;
        }

        return Math.max(lengthRequirement, charRequirement);
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String password = bufferedReader.readLine();

        int answer = Result.minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
