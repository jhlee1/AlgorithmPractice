package hackerrank.three_month_interview_prep_kit.week_2.lonely_integer;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'lonelyinteger' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int lonelyinteger(List<Integer> a) {
        Map<Integer, Integer> nums = new HashMap<>();

        a.forEach(
                num -> {
                    nums.computeIfPresent(num, (key, val) -> ++val);
                    nums.putIfAbsent(num, 1);
                }
        );

        return nums.entrySet()
                .stream()
                .filter(entry -> entry.getValue() == 1)
                .findAny()
                .orElseThrow(() -> new AssertionError("No Lonely integer exists"))
                .getKey();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.lonelyinteger(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
