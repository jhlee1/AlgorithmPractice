package leetcode.ransom_note;

// 383. https://leetcode.com/problems/ransom-note/

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] ransomNoteLetterCounts = new int['z' - 'a' + 1];
        int[] magazineLetterCounts = new int['z' - 'a' + 1];

        for (char c : magazine.toCharArray()) {
            magazineLetterCounts[c - 'a'] += 1;
        }

        for (char c : ransomNote.toCharArray()) {
            ransomNoteLetterCounts[c - 'a'] += 1;

            if (magazineLetterCounts[c - 'a'] < ransomNoteLetterCounts[c - 'a']) {
                return false;
            }
        }

        return true;
    }
}
