package leetcode.valid_palindrome;

// 125. https://leetcode.com/problems/valid-palindrome/description/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean isPalindrome(String s) {
        List<Character> chars = new ArrayList<>();
        for (char c : s.toLowerCase().toCharArray()) {
            if ((c <= 'z' && c >= 'a') || (c <= '9' && c >= '0')) {
                chars.add(c);
            }
        }
        int left = 0;
        int right = chars.size() - 1;

        while (left < right) {
            if (chars.get(left) != chars.get(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}