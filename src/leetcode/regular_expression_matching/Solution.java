package leetcode.regular_expression_matching;

/**
 * Created by Joohan Lee on 2020/02/04
 */
public class Solution {
  public static boolean isMatch(String s, String p) {
    int sIndex = 0;
    int pIndex = 0;

    while(pIndex < s.length()  && sIndex < p.length()) {
      if (p.charAt(pIndex) == '*') {
        pIndex--;
        while (sIndex >= 0 &&isEqual(p.charAt(pIndex), s.charAt(sIndex))) {
          sIndex--;
        }
        pIndex--;
      } else {
        if (!isEqual(p.charAt(pIndex), s.charAt(sIndex))) {
          return false;
        }
        pIndex--;
        sIndex--;
      }
    }

    if (sIndex > 0 || pIndex > 0) {
      return false;
    }

    return true;
  }

  private static boolean isEqual(char left, char right) {
    if (left == '.' || right == '.') {
      return true;
    } else if (left == right) {
      return true;
    } else {
      return false;
    }
  }


  public static void main(String[] args) {
    System.out.println(isMatch("aa", "a"));
    System.out.println(isMatch("aa", "a*"));
    System.out.println(isMatch("ab", ".*"));
    System.out.println(isMatch("aab", "c*a*b"));
    System.out.println(isMatch("mississippi", "mis*is*p*."));
    System.out.println(isMatch("mississippi", "mis*is*ip*."));
        System.out.println(isMatch("aaa", "aaaa"));
  }
}

//Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
//
//'.' Matches any single character.
//'*' Matches zero or more of the preceding element.
//The matching should cover the entire input string (not partial).
//
//Note:
//
//s could be empty and contains only lowercase letters a-z.
//p could be empty and contains only lowercase letters a-z, and characters like . or *.
//Example 1:
//
//Input:
//s = "aa"
//p = "a"
//Output: false
//Explanation: "a" does not match the entire string "aa".



//Example 2:
//
//Input:
//s = "aa"
//p = "a*"
//Output: true
//Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
//Example 3:
//
//Input:
//s = "ab"
//p = ".*"
//Output: true
//Explanation: ".*" means "zero or more (*) of any character (.)".
//Example 4:
//
//Input:
//s = "aab"
//p = "c*a*b"
//Output: true
//Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
//Example 5:
//
//Input:
//s = "mississippi"
//p = "mis*is*p*."
//Output: false