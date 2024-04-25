package leetcode.longest_substring_without_repeating_characters;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Joohan Lee on 2020/01/02
 */

// 3. https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution {
  public int lengthOfLongestSubstring(String s) {
    if (s.isEmpty()) {
      return 0;
    }

    if (s.length() < 2) {
      return 1;
    }

    char[] chars = s.toCharArray();
    Set<Character> windowedChars = new HashSet<>();
    int left = 0;
    int result = 0;
    windowedChars.add(chars[left]);


    for(int i = 1; i < chars.length; i++) {
      while (windowedChars.contains(chars[i])) {
        windowedChars.remove(chars[left]);
        left++;
      }
      windowedChars.add(chars[i]);
      result = Math.max(result, i - left + 1);
    }

    return result;
  }
}

