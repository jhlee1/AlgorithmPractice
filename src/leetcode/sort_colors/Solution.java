package leetcode.sort_colors;

import java.util.Arrays;

// 75. Sort Colors https://leetcode.com/problems/sort-colors/description/

class Solution {
    public void sortColors(int[] nums) {
        int redCount = 0;
        int whiteCount = 0;
        int blueCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                redCount++;
            } else if (nums[i] == 1) {
                whiteCount++;
            } else if (nums[i] == 2) {
                blueCount++;
            } else {
                System.out.println("UnexpectedColor");
            }
        }

        Arrays.fill(nums, 0, redCount, 0);
        Arrays.fill(nums, redCount, redCount + whiteCount, 1);
        Arrays.fill(nums, redCount + whiteCount, redCount + whiteCount + blueCount, 2);
    }
}