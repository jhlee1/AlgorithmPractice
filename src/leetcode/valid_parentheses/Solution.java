package leetcode.valid_parentheses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

// 20. https://leetcode.com/problems/valid-parentheses/

class Solution {
  public boolean isValid(String s) {
    Stack<Character> chars = new Stack<>();

    for (char c : s.toCharArray()) {
      if (c == '(' || c == '{' || c == '[') {
        chars.add(c);
      } else {

        if (chars.isEmpty()) {
          return false;
        }
        char polledChar = chars.pop();

        if (polledChar == '(' && c != ')') {
          return false;
        }

        if (polledChar == '{' && c != '}') {
          return false;
        }

        if (polledChar == '[' && c != ']') {
          return false;
        }
      }
    }

    return chars.isEmpty();

  }
}

//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//An input string is valid if:
//
//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
//Note that an empty string is also considered valid.
//
//Example 1:
//
//Input: "()"
//Output: true
//Example 2:
//
//Input: "()[]{}"
//Output: true
//Example 3:
//
//Input: "(]"
//Output: false
//Example 4:
//
//Input: "([)]"
//Output: false
//Example 5:
//
//Input: "{[]}"
//Output: true