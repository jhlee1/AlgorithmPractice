package leetcode.palindrome_number;

/**
 * Created by Joohan Lee on 2020/02/03
 */
public class Solution {

  public static void main(String[] args) {
    System.out.println(isPalindrome(-10));
  }

  private static boolean isPalindrome(int x) {
    final int originalInput = x;
    int reversed = 0;

    if (x < 0) {
      return false;
    }

    while (x > 0) {
      reversed *= 10;
      reversed += x % 10;
      x /= 10;
    }

    return reversed == originalInput;
  }
}

// Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
//
//Example 1:
//
//Input: 121
//Output: true
//
//Example 2:
//
//Input: -121
//Output: false
//Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
//
//Example 3:
//
//Input: 10
//Output: false
//Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
//
//Follow up:
//
//Coud you solve it without converting the integer to a string?
