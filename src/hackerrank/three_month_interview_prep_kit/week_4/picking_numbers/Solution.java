package hackerrank.three_month_interview_prep_kit.week_4.picking_numbers;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'pickingNumbers' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int pickingNumbers(List<Integer> a) {
        int result = 0;
        Map<Integer, Integer> nums = new HashMap<>();

        a.forEach(i -> {
            nums.computeIfPresent(i, (key, val) -> ++val);
            nums.putIfAbsent(i, 1);
        });

        if (nums.size() < 2) {
            return nums.values().iterator().next();
        }

        List<Integer> uniqueNums = nums.keySet()
                .stream()
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());

        for (int i = 1; i < uniqueNums.size(); i++) {
            if ((uniqueNums.get(i) - uniqueNums.get(i - 1)) < 2) {
                int maxLength = nums.get(uniqueNums.get(i)) + nums.get(uniqueNums.get(i - 1));

                result = Math.max(maxLength, result);
            } else {
                result = Math.max(nums.get(uniqueNums.get(i)), result);
            }
        }

        return result;
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

        int result = Result.pickingNumbers(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
