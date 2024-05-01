package leetcode.backspace_string_compare;

import java.util.Stack;

// 844. Backspace String Compare https://leetcode.com/problems/backspace-string-compare/

class Solution {

    // Using a stack
    // Time complexity: O(n), Space complexity: O(n)
    public boolean backspaceCompareUsingStack(String s, String t) {
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!left.isEmpty()) {
                    left.pop();
                }
            } else {
                left.add(c);
            }
        }

        for (char c : t.toCharArray()) {
            if (c == '#') {
                if (!right.isEmpty()) {
                    right.pop();
                }
            } else {
                right.add(c);
            }
        }


        while (!left.isEmpty() && !right.isEmpty()) {
            if (!left.pop().equals(right.pop())) {
                return false;
            }
        }

        return left.isEmpty() && right.isEmpty();
    }

    // Reading from the back
    // Time complexity: O(n), Space complexity: O(1)
    public boolean backspaceCompare(String s, String t) {
        int left = s.length() - 1;
        int right = t.length() - 1;
        int leftSkip = 0;
        int rightSkip = 0;

        while (left >= 0 || right >= 0) {
            if (left >= 0 && s.charAt(left) == '#') {
                leftSkip++;
                left--;
                continue;
            }

            if (leftSkip > 0) {
                leftSkip--;
                left--;
                continue;
            }

            if (right >= 0 && t.charAt(right) == '#') {
                rightSkip++;
                right--;
                continue;
            }

            if (rightSkip > 0) {
                rightSkip--;
                right--;
                continue;
            }

            if ((left < 0 && right >= 0) || (right < 0 && left >= 0)) {
                return false;
            }

            if (s.charAt(left) != t.charAt(right)) {
                return false;
            } else {
                right--;
                left--;
            }
        }

        return true;
    }


}