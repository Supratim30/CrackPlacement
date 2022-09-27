class Solution {

    //tabulation
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] a : dp) Arrays.fill(a, 0);

        for (int t = 0; t <= amount; t++) dp[0][t] = t % coins[0] == 0 ? 1 : 0;

        for (int i = 1; i < n; i++) {
            for (int tar = 0; tar <= amount; tar++) {
                int notTake = dp[i - 1][tar];
                int take = 0;
                if (coins[i] <= tar) take = dp[i][tar - coins[i]];
                dp[i][tar] = take + notTake;
            }
        }
        return dp[n - 1][amount];
    }
}
