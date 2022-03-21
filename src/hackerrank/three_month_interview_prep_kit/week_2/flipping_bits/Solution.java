package hackerrank.three_month_interview_prep_kit.week_2.flipping_bits;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'flippingBits' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER n as parameter.
     */

    public static long flippingBits(long n) {
        int[] n_in_bits = new int[32];

        int i = 0;

        while (n > 0) {
            n_in_bits[i] = (int) (n % 2);
            n /= 2;
            i++;
        }

        long result = 0;

        for (int j = 0; j < n_in_bits.length; j++) {
            if (n_in_bits[j] == 0) {
                result += Math.pow(2, j);
            }
        }

        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        long result = Result.flippingBits(3);

        System.out.println(result);
    }
}
