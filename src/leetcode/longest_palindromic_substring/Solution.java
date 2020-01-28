package leetcode.longest_palindromic_substring;

/**
 * Created by Joohan Lee on 2020/01/16
 */
public class Solution {
  public String longestPalindrome(String s) {
    int chunkSize = s.length();

    while (chunkSize > 0) {
      for (int i = 0; i <= s.length() - chunkSize; i++) {
        final String substring = s.substring(i, i + chunkSize);
        if (isPalindrome(substring)) {
          return substring;
        }
      }

      chunkSize--;
    }

    return "";
  }

  private boolean isPalindrome(String s) {
    final int halfLength = s.length() / 2;
    for (int i = 0; i < halfLength; i++) {
      if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
        return false;
      }
    }

    return true;
  }
}


//iven a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
//
//Example 1:
//
//Input: "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
//Example 2:
//
//Input: "cbbd"
//Output: "bb"