package leetcode.valid_parentheses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Joohan Lee on 2020/05/13
 */
public class Solution {

  public static void main(String[] args) {

  }

  public static boolean isValid(String s) {
    List<Character> leftSides = Arrays.asList('(', '{', '[');
    Stack<Character> charactersOnLeft = new Stack<>();

    for (char c : s.toCharArray()) {
      if (leftSides.contains(c)) {
        charactersOnLeft.push(c);
      } else {
        if (charactersOnLeft.isEmpty() || !isPair(charactersOnLeft.pop(), c)) {
          return false;
        }
      }
    }

    return charactersOnLeft.isEmpty();
  }

  private static boolean isPair(char left, char right) {
    switch (right) {
      case ']':
        return left == '[';
      case '}':
        return left == '{';
      case ')':
        return left == '(';
      default:
        return false;
    }
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