package leetcode.two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        int[] result = new int[2];

        for(int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new LinkedList<>());
            map.get(nums[i]).add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            int firstNum = nums[i];
            if(map.get(target - firstNum) != null) {
                result[0] = map.get(firstNum).poll();

                if (!map.get(target - firstNum).isEmpty()) {
                    result[1] = map.get(target - firstNum).poll();
                    Arrays.sort(result);

                    return result;
                }
            }
        }

        return null;
    }
}