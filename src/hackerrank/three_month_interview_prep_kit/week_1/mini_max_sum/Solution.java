package hackerrank.three_month_interview_prep_kit.week_1.mini_max_sum;

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



public class Solution {
    public static void main(String[] args) throws IOException {
        List<Integer> arr = Stream.of(5, 2, 3, 4, 5).collect(toList());

        Result.miniMaxSum(arr);
    }

    public static class Result {
        public static void miniMaxSum(List<Integer> arr) {
            List<Integer> sorted = arr.stream().sorted(Integer::compareTo).collect(toList());
            long max = 0, min = 0;

            for (int i = 1; i < 4; i++) {
                max += sorted.get(i);
                min += sorted.get(i);
            }

            min += sorted.get(0);
            max += sorted.get(4);

            System.out.println(min + " " + max);
        }

    }
}
