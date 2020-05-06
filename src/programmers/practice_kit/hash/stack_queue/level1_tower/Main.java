package programmers.practice_kit.hash.stack_queue.tower;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by Joohan Lee on 2020/05/06
 */
public class Main {

  public static void main(String[] args) {

    int[] input = new int[]{6, 9, 5, 7, 4};

    System.out.println(Arrays.stream(solution(input)).boxed().map(String::valueOf).collect(Collectors.joining(",")));
  }


  public static int[] solution(int[] heights) {
    int[] result = new int[heights.length];

    for (int i = heights.length - 1; i >= 0; i--) {
      final int currentHeight = heights[i];
      boolean hasReceiver = false;

      for (int j = i - 1; j >= 0; j--) {
        if (heights[j] > currentHeight) {
          result[i] = j + 1;
          hasReceiver = true;
          break;
        }
      }

      if (!hasReceiver) {
        result[i] = 0;
      }
    }

    return result;
  }

}
