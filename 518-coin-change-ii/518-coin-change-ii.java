class Solution {

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] a : dp) Arrays.fill(a, -1);
        return helper(n - 1, amount, coins, dp);
    }

    private int helper(int idx, int target, int[] coins, int[][] dp) {
        if (idx == 0) return target % coins[0] == 0 ? 1 : 0;
        if (dp[idx][target] != -1) return dp[idx][target];
        int notTake = helper(idx - 1, target, coins, dp);
        int take = 0;
        if (coins[idx] <= target) take = helper(idx, target - coins[idx], coins, dp);

        return dp[idx][target] = notTake + take;
    }
}
