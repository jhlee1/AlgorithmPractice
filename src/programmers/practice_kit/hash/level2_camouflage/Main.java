package programmers.practice_kit.hash.level2_camouflage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Joohan Lee on 2020/05/06
 */
public class Main {

  public static void main(String[] args) {

//    int result = solution(new String[][] { new String[] {"crow_mask", "face"}, new String[] {"blue_sunglasses", "face"}, new String[] {"smoky_makeup", "face"}});

    int result = solution(new String[][] { new String[] {"동그란안경", "얼굴"}, new String[] {"검정 선글라스", "얼굴"}, new String[] {"청바지", "하의"}, new String[] {"파란색티셔츠", "상의"}, new String[] {"긴 코", "겉옷"}, });

    System.out.println(result);
  }


  public static int solution(String[][] clothes) {
    Map<String, List<String>> clothOfType = new HashMap<>();

    for(String[] cloth : clothes) {
      final String name = cloth[0];
      final String type = cloth[1];

      clothOfType.putIfAbsent(type, new ArrayList<>());
      clothOfType.get(type).add(name);
    }

    final int result = clothOfType.values().stream()
        .map(it -> it.size() + 1)
        .reduce(Math::multiplyExact)
        .orElse(0);

    return result - 1;
  }
}
