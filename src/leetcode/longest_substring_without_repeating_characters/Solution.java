package leetcode.longest_substring_without_repeating_characters;

/**
 * Created by Joohan Lee on 2020/01/02
 */
class Solution {
  public int lengthOfLongestSubstring(String s) {
    int longestSubString = 0;
    String[] inputAsArray = s.split("");

    for (int i = 0; i < s.length(); i++) {
      int currentSubString = 1;
      String tmp = inputAsArray[i];

      for (int j = i + 1; j < s.length(); j++) {
        if (tmp.contains(inputAsArray[j])) {
          break;
        } else {
          tmp += inputAsArray[j];
          currentSubString++;
        }
      }

      longestSubString = Math.max(longestSubString, currentSubString);
    }

    return longestSubString;
  }
}


