package hackerrank.interview_prep_kit.string_manipulation.special_palindrome;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static long substrCount(int n, String s) {
        long result = 0;
        char[] chars = s.toCharArray();

        for (int i = 0; i < n; i++) {
            int offset = 1;
            int sameChars = 1;

            while(i - offset >= 0 && i + offset < n) {
                if (chars[i - offset] == chars[i + offset] && chars[i - offset] == chars[i - 1]) {
                    result++;
                    offset++;
                } else {
                    break;
                }
            }

            while(i < n - 1 && chars[i] == chars[i + 1]) {
                i++;
                sameChars++;
            }
            result += sameChars * (sameChars + 1) / 2;
        }

        return result;
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
