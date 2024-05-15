package leetcode.merge_intervals;

import java.util.Arrays;
// 56. merge intervals https://leetcode.com/problems/merge-intervals/
class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int left = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[left][1] >= intervals[i][0]) {
                intervals[left][0] = Math.min(intervals[left][0], intervals[i][0]);
                intervals[left][1] = Math.max(intervals[left][1], intervals[i][1]);
            } else if (intervals[left][1] < intervals[i][0]) {
                left++;
                intervals[left][0] = intervals[i][0];
                intervals[left][1] = intervals[i][1];
            }
        }

        int[][] result = new int[left + 1][2];
        System.arraycopy(intervals, 0, result, 0, left + 1);


        return result;
    }
}