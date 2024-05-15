package leetcode.combination_sum;

import java.util.ArrayList;
import java.util.List;

// 39. Combination Sum https://leetcode.com/problems/combination-sum/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        sum(candidates, 0, target, new ArrayList<>(), result);

        return result;
    }

    public void sum(int[] candidates, int index, int target, List<Integer> combination, List<List<Integer>> result) {
        if (target < 0 || index >= candidates.length) {
            return;
        }

        if (target == 0) {
            result.add(combination);
            return;
        }

        sum(candidates, index + 1, target, new ArrayList<>(combination), result);
        combination.add(candidates[index]);
        sum(candidates, index, target - candidates[index], combination, result);

    }

}
