package hackerrank.three_month_interview_prep_kit.week_4.separate_the_numbers;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'separateNumbers' function below.
     *
     * The function accepts STRING s as parameter.
     */

    public static void separateNumbers(String s) {
        for (int i = 1; i <= s.length() / 2; i++) {
            if (processNums(Long.parseLong(s.substring(0, i)), s.substring(i))) {
                System.out.println("YES " + s.substring(0, i));
                return;
            }
        }

        System.out.println("NO");
    }


    private static boolean processNums(long previous, String current) {
        if (current.startsWith("0")) {
            return false;
        }

        if (current.length() == 0) {
            return true;
        }

        int maxCurrentLength = Math.min(String.valueOf(previous).length() + 1, current.length());

        for (int i = 1 ; i <= maxCurrentLength; i++) {
            long currentVal = Long.parseLong(current.substring(0, i));

            if (currentVal - 1 == previous) {
                return processNums(currentVal, current.substring(i));
            }
        }

        return false;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String s = bufferedReader.readLine();

                Result.separateNumbers(s);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}

