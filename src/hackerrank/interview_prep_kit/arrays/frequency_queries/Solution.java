package hackerrank.interview_prep_kit.arrays.frequency_queries;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.stream.Collectors.joining;

public class Solution {

    // Complete the freqQuery function below.
    static List<Integer> freqQuery(int[][] queries) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> frequencies = new HashMap<>();
        List<Integer> outputs = new ArrayList<>();

        for(int[] query : queries) {
            final int command = query[0];
            final int num = query[1];

            switch (command) {
                case 1:
                    map.computeIfPresent(num, (key, val) -> val + 1);
                    map.putIfAbsent(num, 1);

                    frequencies.computeIfPresent(map.get(num), (key, val) -> val + 1);
                    frequencies.putIfAbsent(map.get(num), 1);
                    frequencies.computeIfPresent(map.get(num) - 1, (key, val) -> val > 0 ? val - 1 : 0);
                    break;
                case 2:
                    if(map.get(num) != null) {
                        frequencies.computeIfPresent(map.get(num), (key, val) -> val < 1 ? 0 : val - 1);
                        frequencies.computeIfPresent(map.get(num) - 1, (key, val) -> val + 1);
                        map.compute(num, (key, val) -> val < 1 ? 0 : val - 1);
                    }
                    break;
                case 3:
                    if(frequencies.get(num) != null && frequencies.get(num) > 0) {
                        outputs.add(1);
                    } else{
                        outputs.add(0);
                    }
                    break;
                default:
                    throw new AssertionError();
            }
        }

        return outputs;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());
        int[][] queries = new int[q][2];
        Pattern p  = Pattern.compile("^(\\d+)\\s+(\\d+)\\s*$");
        for (int i = 0; i < q; i++) {
            Matcher m = p.matcher(bufferedReader.readLine());

            if (m.matches()) {
                queries[i][0] = Integer.parseInt(m.group(1));
                queries[i][1] = Integer.parseInt(m.group(2));
            }
        }
        List<Integer> ans = freqQuery(queries);


        bufferedWriter.write(
                ans.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}