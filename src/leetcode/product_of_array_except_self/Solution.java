package leetcode.product_of_array_except_self;

// 238. Product of Array Except Self https://leetcode.com/problems/product-of-array-except-self/
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;

        for (int i = 0; i < nums.length - 1; i++) {
            result[i + 1] = result[i] * nums[i];
        }

        int tmp = 1;

        for (int i = nums.length - 1; i > 0; i--) {
            tmp *= nums[i];
            result[i - 1] *= tmp;
        }

        return result;
    }
}
