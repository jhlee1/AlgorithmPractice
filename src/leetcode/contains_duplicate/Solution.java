package leetcode.contains_duplicate;

import java.util.HashSet;
import java.util.Set;

// 217. https://leetcode.com/problems/contains-duplicate/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();

        for (int num : nums) {
            if (uniqueNums.contains(num)) {
                return true;
            }

            uniqueNums.add(num);
        }

        return false;

    }
}

