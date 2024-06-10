package leetcode.letter_combinations_of_a_phone_number;

import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }

        String[] digitToChars = new String[10];

        digitToChars[2] = "abc";
        digitToChars[3] = "def";
        digitToChars[4] = "ghi";
        digitToChars[5] = "jkl";
        digitToChars[6] = "mno";
        digitToChars[7] = "pqrs";
        digitToChars[8] = "tuv";
        digitToChars[9] = "wxyz";

        Queue<String> result = new LinkedList<>();
        result.add("");

        for (char inputChar : digits.toCharArray()) {
            int size = result.size();
            for (int i = 0; i < size; i ++) {
                String tmp = result.poll();
                for (char c : digitToChars[inputChar - '0'].toCharArray()) {
                    result.add(tmp + c);
                }
            }
        }

        return new ArrayList<>(result);

    }
}