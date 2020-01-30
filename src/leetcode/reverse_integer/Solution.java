package leetcode.reverse_integer;

/**
 * Created by Joohan Lee on 2020/01/29
 */
public class Solution {
  public static int reverse(int x) {
    final char[] input = String.valueOf(x).toCharArray();
    char[] result = new char[input.length]; // Digits of Max Integer
    int numberStartAtIndex = input[0] == '-' ? 1 : 0;
    int index = numberStartAtIndex;

    for (int i = input.length - 1; i >= numberStartAtIndex; i--) {
      result[index] = input[i];
      index++;
    }

    if (isOverflow(result, numberStartAtIndex)) {
      return 0;
    }

    if (numberStartAtIndex == 1) {
      result[0] = input[0];
    }

    return Integer.parseInt(String.valueOf(result));
  }

  private static boolean isOverflow(char[] input, int startFrom) {
    final char[] intMax = String.valueOf(Integer.MAX_VALUE).toCharArray();
    int maxIndex = 0;

    if (input.length - startFrom < intMax.length) {
      return false;
    }

    for(int i = startFrom; i < input.length; i++) {
      if (intMax[maxIndex] < input[i]) {
        return true;
      } else if (intMax[maxIndex] > input[i]) {
        return false;
      }

      maxIndex++;
    }

    return false;
  }

  public static void main(String[] args) {
    System.out.println(reverse(-563847412));
  }
}
