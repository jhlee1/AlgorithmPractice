package leetcode.binary_search;


// 704. https://leetcode.com/problems/binary-search/description/

class Solution {
    public int search(int[] nums, int target) {
        int upperBound = nums.length - 1;
        int lowerBound = 0;

        while (lowerBound <= upperBound) {
            int mid = (upperBound + lowerBound) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                lowerBound = mid + 1;
            } else {
                upperBound = mid - 1;
            }
        }

        return -1;
    }
}
