package leetcode.best_time_to_buy_and_sell_stock;

// 121. https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int min = Integer.MAX_VALUE;

        for (int price : prices) {
            if (min > price) {
                min = price;
            }

            result = Math.max(price - min, result);

        }

        return result;
    }
}
