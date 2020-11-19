package programmers.practice_kit.stack_queue.level2_truck_on_the_bridge;

import java.util.LinkedList;

/**
 * Created by Joohan Lee on 2020/05/06
 */
public class Main {

  public static void main(String[] args) {
//2	10	[7,4,5,6]	8
//100	100	[10]	101
//100	100	[10,10,10,10,10,10,10,10,10,10]	110


    System.out.println(solution(2, 10, new int[] {7, 4, 5, 6}));
  }

  public static int solution(int bridge_length, int weight, int[] truck_weights) {
    int answer = 0;
    int index = 0;
    int currentWeight = 0;
    LinkedList<Integer> bridge = new LinkedList<>();

    do {
      System.out.println("Truck weights: " + truck_weights[index] + " weight: " + currentWeight);

      if (currentWeight + truck_weights[index] <= weight) {
        currentWeight += truck_weights[index];

        bridge.add(bridge_length);
        index++;
      }

      answer++;

      for (int j = 0; j < bridge.size(); j++) {
        bridge.set(j, bridge.get(j) - 1);
      }

      if (bridge.element() <= 0) {
        currentWeight -= truck_weights[index - 1];
        bridge.poll();
      }
    } while (index < truck_weights.length && currentWeight > 0);

    return answer;
  }
}
