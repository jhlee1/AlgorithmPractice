package hackerrank.interview_prep_kit.string_manipulation.strings_making_anagrams;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
        int result = 0;
        Map<Character, Integer> firstStringMap = new HashMap<>();
        Map<Character, Integer> secondStringMap = new HashMap<>();

        for(char c : a.toCharArray()) {
            firstStringMap.computeIfPresent(c, (key, value) -> ++value);
            firstStringMap.putIfAbsent(c, 1);
        }

        for(char c : b.toCharArray()) {
            secondStringMap.computeIfPresent(c, (key, value) -> ++value);
            secondStringMap.putIfAbsent(c, 1);
        }

        for(Map.Entry<Character, Integer> entry : firstStringMap.entrySet()) {
            if (secondStringMap.containsKey(entry.getKey())) {
                result += Math.abs(secondStringMap.get(entry.getKey()) - entry.getValue());
            } else {
                result += entry.getValue();
            }
        }

        for(Map.Entry<Character, Integer> entry : secondStringMap.entrySet()) {
            if (!firstStringMap.containsKey(entry.getKey())) {
                result += entry.getValue();
            }
        }
        return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();
        scanner.close();
    }
}
