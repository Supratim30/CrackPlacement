//leetcode 121

class Solution {
    public int maxProfit(int[] prices) {
        int curmin = prices.length > 0 ? prices[0] : 0;
        int profit = 0;
        for(int i = 0; i < prices.length; i++){
            curmin = Math.min(curmin, prices[i]);
            profit = Math.max(profit, prices[i] - curmin);
        }
        return profit;
    }
}
