package hackerrank.three_month_interview_prep_kit.week_4.closest_numbers;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'closestNumbers' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> closestNumbers(List<Integer> arr) {
        List<Integer> numbers = arr.stream()
                .sorted(Integer::compareTo)
                .collect(Collectors.toList());

        List<Integer> result = new ArrayList();
        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i < numbers.size() - 1; i++) {
            int currentDiff = numbers.get(i + 1) - numbers.get(i);
            if (currentDiff <= minDiff) {
                if (currentDiff < minDiff) {
                    minDiff = currentDiff;
                    result.clear();
                }

                result.add(numbers.get(i));
                result.add(numbers.get(i + 1));
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

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.closestNumbers(arr);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
