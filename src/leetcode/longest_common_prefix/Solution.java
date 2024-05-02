package leetcode.longest_common_prefix;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        int maxLength = strs[0].length();
        for (String s : strs) {
            maxLength = Math.min(maxLength, s.length());
        }

        for (int index = 0; index < maxLength; index++) {
            char c = strs[0].charAt(index);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].charAt(index) != c) {
                    return result.toString();
                }
            }

            result.append(c);
        }

        return result.toString();
    }
}
