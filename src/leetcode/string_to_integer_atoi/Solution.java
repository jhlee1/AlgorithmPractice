package leetcode.string_to_integer_atoi;

/**
 * Created by Joohan Lee on 2020/01/31
 */
public class Solution {
  public int myAtoi(String str) {
    long result = 0;
    boolean isNegative = false;
    int index = 0;
    char[] input = str.toCharArray();

    if (!str.matches(" *[+,-]?[0-9]+.*")) {
      return 0;
    }

    while (input[index] == ' ' || input[index] == '+') {
      index++;
    }

    if (input[index] == '-') {
      isNegative = true;
      index++;
    }

    while(index < input.length) {
      if ( '0' <= input[index] && input[index] <= '9') {
        result *= 10;
        result += input[index] - '0';

        if (result > Integer.MAX_VALUE) {
          if (isNegative) {
            return Integer.MIN_VALUE;
          } else {
            return Integer.MAX_VALUE;
          }
        }
      } else {
        break;
      }

      index++;
    }

    if (isNegative) {
      result *= -1;
    }

    return (int) result;
  }
}
