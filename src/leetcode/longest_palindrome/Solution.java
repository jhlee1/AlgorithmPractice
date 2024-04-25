package leetcode.longest_palindrome;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> chars = new HashMap<>();
        int result = s.length();

        for (char c : s.toCharArray()) {
            chars.put(c, chars.getOrDefault(c, 0) + 1);
        }

        for (Integer v : chars.values()) {
            result -= v % 2;
        }

        if (result < s.length()) {
            result++;
        }

        return result;

    }
}