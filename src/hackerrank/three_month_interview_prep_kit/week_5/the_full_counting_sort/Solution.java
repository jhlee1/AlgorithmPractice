package hackerrank.three_month_interview_prep_kit.week_5.the_full_counting_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'countSort' function below.
     *
     * The function accepts 2D_STRING_ARRAY arr as parameter.
     */

    public static void countSort(List<List<String>> arr) {
        int numberOfDashed = arr.size() / 2;
        Map<Integer, List<String>> result = new HashMap<>();

        for (List<String> line : arr) {
            int index = Integer.parseInt(line.get(0));
            String word = line.get(1);

            if (numberOfDashed > 0) {
                word = "-";
                numberOfDashed--;
            }

            result.putIfAbsent(index, new ArrayList<>());

            result.get(index).add(word);
        }

        String output = result.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(e -> e.getValue().stream().collect(Collectors.joining(" ")))
                .collect(Collectors.joining(" "));

        System.out.println(output);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        Result.countSort(arr);

        bufferedReader.close();
    }
}

