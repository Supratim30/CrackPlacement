//https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1\


//Memoize
class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        int[][] dp = new int[N][W + 1];
        for(int[] a : dp) Arrays.fill(a, -1);
        return helper(N - 1, W, val, wt, dp);
    }
    static int helper(int idx, int W, int val[], int wt[], int[][] dp){
        if(idx == 0) return ((int) W / wt[0]) * val[0];
        
        if(dp[idx][W] != -1) return dp[idx][W];
        
        int notTake = 0 + helper(idx - 1, W, val, wt, dp);
        int take  = 0;
        if(wt[idx] <= W) take = val[idx] + helper(idx, W - wt[idx], val, wt, dp);
        
        return dp[idx][W] = Math.max(take, notTake);
    }
}

//tabulation
class Solution{
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        int[][] dp = new int[N][W + 1];
        for(int weight = 0; weight <= W; weight++){
            dp[0][weight] = ((int) (weight / wt[0])) * val[0];
        }
        
        for(int idx = 1; idx < N; idx++){
            for(int weight = 0; weight <= W; weight++){
                int notTake = 0 + dp[idx - 1][weight];
                int take = 0;
                if(wt[idx] <= weight) take = val[idx] + dp[idx][weight - wt[idx]];
                
                dp[idx][weight] = Math.max(take, notTake);
            }
        }
        return dp[N - 1][W];
    }
}
