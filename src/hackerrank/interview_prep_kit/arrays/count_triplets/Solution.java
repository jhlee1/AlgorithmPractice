package hackerrank.interview_prep_kit.arrays.count_triplets;

import java.io.*;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Solution {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        long numOfTriplets = 0;
        Map<Long, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < arr.size(); i++) {
            final long num = arr.get(i);

            map.putIfAbsent(num, new ArrayList<>());
            map.get(num).add(i);
        }

        for (int i = 0; i < arr.size(); i++) {
            final long currentNum = arr.get(i);
            final long secondNum = currentNum * r;
            final long thirdNum = currentNum * r * r;

            if(map.containsKey(secondNum) && map.containsKey(thirdNum)) {
                final int currentNumIndex = i;

                List<Integer> secondNums = map.get(secondNum).stream().filter(index -> index > currentNumIndex)
                        .collect(toList());

                for(int secondNumIndex : secondNums) {
                    long thirdNumIndexes = map.get(thirdNum).stream()
                            .filter(index -> index > secondNumIndex)
                            .count();

                    numOfTriplets += thirdNumIndexes;
                }
            }
        }

        return numOfTriplets;
    }


    static long countTriplets2(List<Long> arr, long r) {
        long numOfTriplets = 0;
        Map<Long, Integer> map = new HashMap<>();

        for(long num : arr) {
            map.computeIfPresent(num, (key, val) -> val + 1);
            map.putIfAbsent(num, 1);
        }

        return numOfTriplets;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
