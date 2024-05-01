package leetcode.coin_change;

import java.util.Arrays;

// 322. Coin Change https://leetcode.com/problems/coin-change/

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, amount + 1);
        Arrays.sort(coins);

        memo[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int c = 0; c < coins.length; c++) {
                if (i - coins[c] >= 0) {
                    memo[i] = Math.min(memo[i], memo[i - coins[c]] + 1);
                } else{
                    break;
                }

            }
        }

        if (memo[amount] < amount + 1) {
            return memo[amount];
        } else {
            return -1;
        }


    }


}