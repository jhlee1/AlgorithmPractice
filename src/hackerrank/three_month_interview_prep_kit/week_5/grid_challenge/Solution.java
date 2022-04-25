package hackerrank.three_month_interview_prep_kit.week_5.grid_challenge;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Result {

    /*
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static String gridChallenge(List<String> grid) {
        List<String> sortedGrid = new ArrayList<>();

        for (String row : grid) {
            char[] sortedRow = row.toCharArray();
            Arrays.sort(sortedRow);


            sortedGrid.add(new String(sortedRow));
        }
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < sortedGrid.size() - 1; j++) {
                if (sortedGrid.get(j).charAt(i) > sortedGrid.get(j + 1).charAt(i)) {
                    return "NO";
                }
            }
        }

        return "YES";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        for (int tItr = 0; tItr < t; tItr++) {
            int n = Integer.parseInt(bufferedReader.readLine().trim());

            List<String> grid = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String gridItem = bufferedReader.readLine();
                grid.add(gridItem);
            }

            String result = Result.gridChallenge(grid);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
