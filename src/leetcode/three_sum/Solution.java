package leetcode.three_sum;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 15. 3sum https://leetcode.com/problems/3sum/description/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = nums[i] * - 1;
            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {
                if (target > nums[left] + nums[right]) {
                    left++;
                } else if (target < nums[left] + nums[right]) {
                    right--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                }
            }



        }

        return result;

    }
}

