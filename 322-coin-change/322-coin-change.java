class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int[] a : dp) Arrays.fill(a, -1);
        
        int res = Math.max(-1 , coin(coins , amount , n-1 , dp));
        if(res >= 1000000) return -1;
        return res;
    }
    
    public int coin(int[] coins , int amount , int idx , int[][] dp){
        if(idx == 0)
        {
            if(amount%coins[0] == 0) return amount/coins[0];
            else return Integer.MAX_VALUE-10000;
        }
        if(amount == 0) return 0;
        if(dp[idx][amount] != -1) return dp[idx][amount];
        
        
        int notTake = coin(coins , amount , idx-1 , dp);
        int take = Integer.MAX_VALUE;
        if(amount >= coins[idx]) take = 1 + coin(coins , amount-coins[idx] , idx , dp);
        
        return dp[idx][amount] = Math.min(take , notTake);
    }
}