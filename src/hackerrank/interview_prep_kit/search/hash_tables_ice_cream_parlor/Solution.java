package hackerrank.interview_prep_kit.search.hash_tables_ice_cream_parlor;

import java.util.*;

public class Solution {

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < cost.length; i++) {
            map.putIfAbsent(cost[i], new ArrayList<>());
            map.get(cost[i]).add(i);
        }

        Iterator<Integer> iterator = map.keySet().iterator();

        while (iterator.hasNext()) {
            int firstNum = iterator.next();
            int secondNum = money - firstNum;

            if (map.get(secondNum) != null && !map.get(secondNum).isEmpty()) {
                if (firstNum == secondNum) {
                    if (map.get(firstNum).size() > 1) {
                        result.add(map.get(firstNum).get(0) + 1);
                        result.add(map.get(firstNum).get(1) + 1);
                        break;
                    }
                } else {
                    result.add(map.get(firstNum).get(0) + 1);
                    result.add(map.get(secondNum).get(0) + 1);
                    break;
                }
            }
        }

        result.sort(Integer::compareTo);
        System.out.println(result.get(0) + " " + result.get(1));
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}

