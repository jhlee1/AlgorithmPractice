package leetcode.valid_anagram;


// 242. https://leetcode.com/problems/valid-anagram/description/
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] firstString = new int['z' - 'a' + 1];
        int[] secondString = new int['z' - 'a' + 1];

        for (char c : s.toCharArray()) {
            firstString[c - 'a'] += 1;
        }

        for (char c : t.toCharArray()) {
            secondString[c - 'a'] += 1;

            if (secondString[c - 'a'] > firstString[c - 'a']) {
                return false;
            }
        }

        return true;
    }
}
