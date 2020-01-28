package leetcode.zigzag_conversion;

/**
 * Created by Joohan Lee on 2020/01/26
 */
public class Solution {
  public static String convert(String s, int numRows) {
    StringBuilder result = new StringBuilder();
    final int jumpSize = numRows * 2 - 2;

    for (int i = 0; i < s.length(); i += jumpSize) {
      result.append(s.charAt(i));
    }

    for (int i = 1; i < numRows - 1; i++) {
      result.append(s.charAt(i));

      int j = i;
      while (j < s.length()) {
        s.charAt(j);

      }

    }

    for (int i = numRows - 1; i < s.length(); i += jumpSize) {
      result.append(s.charAt(i));
    }

    return result.toString();
  }

  public static void main(String[] args) {
    System.out.println(convert("PAYPALISHIRING", 4));
  }

}
