package leetcode.two_sum;

import java.util.*;

class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            int firstNum = nums[i];
            if(map.get(target - firstNum) != null) {
                if (!map.get(target - firstNum).isEmpty()) {
                    result[0] = map.get(firstNum).remove(0);
                    result[1] = map.get(target - firstNum).remove(0);
                }
            }
        }

        Arrays.sort(result);

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};

        twoSum(nums, 9);
    }
}