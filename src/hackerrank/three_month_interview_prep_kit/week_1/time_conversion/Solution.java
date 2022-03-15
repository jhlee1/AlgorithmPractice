package hackerrank.three_month_interview_prep_kit.week_1.time_conversion;

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
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        // Write your code here
        char M = s.charAt(s.length() - 2);
        String[] time = s.replaceAll("[APM]+", "").split(":");
        int hour = Integer.parseInt(time[0]);

        if (hour == 12) {
            hour -= 12;

        }

        System.out.println("M : " + M);

        if (M == 'P') {
            hour += 12;
        }

        String hourInString = String.valueOf(hour);

        int numOfZerosNeeded = 2 - hourInString.length();

        for (int i = 0; i < numOfZerosNeeded; i++) {
            hourInString = "0" + hourInString;
        }

        return new StringBuilder()
                .append(hourInString)
                .append(":")
                .append(time[1])
                .append(":")
                .append(time[2])
                .toString();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        String result = Result.timeConversion("07:05:45PM");

        System.out.println(result);

    }
}
