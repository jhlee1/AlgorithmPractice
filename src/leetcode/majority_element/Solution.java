package leetcode.majority_element;

import java.util.HashMap;
import java.util.Map;

class Solution {
    // HashMap solution
    // Time complexity: O(n)
    // Space complexity: O(n) -> n/2 in the worst case
    public int majorityElementHashMap(int[] nums) {
        Map<Integer, Integer> numCounts = new HashMap<>();
        for (int num : nums) {
            numCounts.put(num, numCounts.getOrDefault(num, 0) + 1);
        }

        int majority = nums.length / 2;

        for (Map.Entry<Integer, Integer> e : numCounts.entrySet()) {
            if (e.getValue() > majority) {
                return e.getKey();
            }
        }

        return -1;

    }

    // Space complexity: O(1)
    // Boyer-Moore Voting Algorithm
    // Time complexity: O(n)
    public int majorityElement(int[] nums) {
        int majorityCount = 1;
        int majorityNum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (majorityNum != nums[i]) {
                majorityCount--;
            } else {
                majorityCount++;
            }

            if (majorityCount == 0) {
                majorityNum = nums[i];
                majorityCount = 1;
            }
        }

        return majorityNum;
    }
}