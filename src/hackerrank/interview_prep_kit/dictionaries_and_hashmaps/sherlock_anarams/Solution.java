package hackerrank.interview_prep_kit.dictionaries_and_hashmaps.sherlock_anarams;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    private static boolean isAnagram(String s1, String s2) {
        Map<Character, Integer> map = new HashMap();

        for(char c : s1.toCharArray()) {
            map.computeIfPresent(c, (key, val) -> ++val);
            map.putIfAbsent(c, 1);
        }

        for(char c : s2.toCharArray()) {
            if(map.get(c) == null || map.get(c) < 1) {
                return false;
            } else {
                map.compute(c, (key, val) -> --val);
            }

        }
        return true;
    }


    // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
        int numOfAnagrams = 0;

        for(int pieceSize = 1; pieceSize < s.length(); pieceSize++) {
            for(int i = 0; i <= s.length() - pieceSize; i++) {
                String piece = s.substring(i, i + pieceSize);

                for (int j = i + 1; j <= s.length() - pieceSize; j++) {
                    if(isAnagram(piece, s.substring(j, j + pieceSize))) {
                        numOfAnagrams++;
                    }
                }
            }
        }
        return numOfAnagrams;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
