package hackerrank.interview_prep_kit.string_manipulation.sherlock_and_the_valid_string;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()) {
            map.computeIfPresent(c, (key, value) -> ++value);
            map.putIfAbsent(c, 1);
        }

        ArrayList<Integer> frequencies = new ArrayList(map.values());
        int firstNumber = frequencies.get(0);
        boolean removed = false;

        for(int i :frequencies) {
            if(firstNumber - i != 0) {
                if(removed) {
                    return "NO";
                } else {
                    removed = true;
                    if (firstNumber == 1) {
                        firstNumber = i;
                    }
                }
            }
        }

        return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
