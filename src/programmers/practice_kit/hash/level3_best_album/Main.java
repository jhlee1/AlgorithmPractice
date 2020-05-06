package programmers.practice_kit.hash.level3_best_album;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Joohan Lee on 2020/05/06
 */
public class Main {

  public static void main(String[] args) {
//["classic", "pop", "classic", "classic", "pop"] 	[500, 600, 150, 800, 2500] 	[4, 1, 3, 0]
    int[] result = solution(new String[]{"classic", "pop", "classic", "classic", "pop"}, new int[]{500, 600, 150, 150, 2500});

    System.out.println(IntStream.of(result).mapToObj(String::valueOf).collect(Collectors.joining(",")));


  }

  public static int[] solution(String[] genres, int[] plays) {
    Map<String, Map<Integer, List<Integer>>> genreAndPlays = new HashMap<>();

    for (int i = 0; i < genres.length; i++) {
      genreAndPlays.putIfAbsent(genres[i], new HashMap<>());
      genreAndPlays.get(genres[i]).putIfAbsent(plays[i], new ArrayList<>());
      genreAndPlays.get(genres[i]).get(plays[i]).add(i);
    }

    return genreAndPlays.entrySet()
        .stream()
        .map(Entry::getValue)
        .map(Map::entrySet)
        .sorted((o1, o2) -> {
          final int val1 = o1
              .stream()
              .map(integerListEntry -> integerListEntry.getKey() * integerListEntry.getValue().size())
              .reduce(Integer::sum)
              .orElse(0);

          final int val2 = o2
              .stream()
              .map(integerListEntry -> integerListEntry.getKey() * integerListEntry.getValue().size())
              .reduce(Integer::sum)
              .orElse(0);

          return Integer.compare(val2, val1);
        })
        .flatMap(entries -> entries.stream()
            .sorted((o1, o2) -> Integer.compare(o2.getKey(), o1.getKey()))
            .flatMap(entry -> entry.getValue().stream())
            .limit(2)
        )
        .mapToInt(Integer::intValue)
        .toArray();
  }

}


//genres 	plays 	return
//["classic", "pop", "classic", "classic", "pop"] 	[500, 600, 150, 800, 2500] 	[4, 1, 3, 0]