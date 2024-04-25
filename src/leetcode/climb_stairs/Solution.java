package leetcode.climb_stairs;


// 70. https://leetcode.com/problems/climbing-stairs/description/
class Solution {

    // Recursion
    // Time complexity O(log(2^n))
    int[] memo = new int[46];
    public int climbStairsRecursion(int n) {

        if (n < 0) {
            return 0;
        }

        if (n == 0) {
            return 1;
        }

        if (memo[n] == 0) {
            memo[n] = climbStairs(n - 1) + climbStairs(n - 2);
        }

        return memo[n];
    }

    // Time complexity: O(n)
    public int climbStairs(int n) {
        if (n < 3) {
            return n;
        }

        int[] memo = new int[n + 1];
        memo[n - 1] = 1;
        memo[n - 2] = 2;

        for (int i = n - 3; i >= 0; i--) {
            memo[i] += memo[i + 1] + memo[i + 2];
        }

        return memo[0];

    }
}
