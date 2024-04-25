package leetcode.two_sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsWithIndexes = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            numsWithIndexes.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int requiredNum = target - nums[i];
            if (numsWithIndexes.containsKey(requiredNum) && numsWithIndexes.get(requiredNum) != i) {
                result[0] = numsWithIndexes.get(requiredNum);
                result[1] = i;
                return result;
            }
        }

        return null;
    }
}