package leetcode.zigzag_conversion;

/**
 * Created by Joohan Lee on 2020/01/26
 */
public class Solution {
  public static String convert(String s, int numRows) {
    if (numRows <= 1) {
      return s;
    }

    char[] result = new char[s.length()];
    int index = 0;
    final int jumpSize = numRows * 2 - 2;

    for (int i = 0; i < s.length(); i += jumpSize) {
      result[index] = s.charAt(i);
      index++;
    }

    for (int i = 1; i < numRows - 1; i++) {
      int j = i;
      int currentIndex = i * 2;
      boolean down = true;
      while (j < s.length()) {
        result[index] = s.charAt(j);
        index++;
        if (down) {
          j += (jumpSize - currentIndex);
          down = false;
        } else {
          j += currentIndex;
          down = true;
        }
      }
    }

    for (int i = numRows - 1; i < s.length(); i += jumpSize) {
      result[index] = s.charAt(i);
      index++;
    }

    return String.valueOf(result);
  }

  public static void main(String[] args) {
    System.out.println(convert("PAYPALISHIRING", 4));
  }

}
