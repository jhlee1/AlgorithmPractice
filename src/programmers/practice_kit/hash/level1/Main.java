package programmers.practice_kit.hash.level1;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

    }

    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> completions = new HashMap<>();

        for (String s : completion) {
            completions.computeIfPresent(s, (key, value) -> ++value);
            completions.putIfAbsent(s, 1);
        }

        for (String s : participant) {
            if (completions.getOrDefault(s, 0) <= 0) {
                return s;
            }
            completions.computeIfPresent(s, (key, value) -> --value);
        }

        return "No one failed";
    }
}
