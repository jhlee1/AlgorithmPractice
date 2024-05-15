package leetcode.permutations;

// 46. permutations  https://leetcode.com/problems/permutations/description/

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        getPermutation(nums, new ArrayList<>(), result);
        return result;
    }

    public void getPermutation(int[] nums, List<Integer> permutation, List<List<Integer>> result) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }

        for (int num : nums) {
            if (!permutation.contains(num)) {
                permutation.add(num);
                getPermutation(nums, permutation, result);
                permutation.remove(permutation.size() - 1);

            }
        }
    }
}