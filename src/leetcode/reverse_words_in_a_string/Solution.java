package leetcode.reverse_words_in_a_string;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String reverseWords(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                if (!sb.isEmpty()) {
                    result.addFirst(sb.toString());
                    sb.delete(0, sb.length());
                }
            } else {
                sb.append(c);
            }
        }

        if (!sb.isEmpty()) {
            result.addFirst(sb.toString());
            sb.delete(0, sb.length());
        }

        return String.join(" ", result);
    }
}
