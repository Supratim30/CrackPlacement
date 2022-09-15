// https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1


class Solution 
{ 
    //Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         int dp[][] = new int[n + 1][W + 1];
         for(int[] row : dp) Arrays.fill(row, -1);
         return helper(W, wt, val, n, dp);
    } 
    static int helper(int W, int wt[], int val[], int n, int[][] dp){
        //base case
        if(n == 0 || W == 0) return 0;
        //memoization
        if(dp[n][W] != -1) return dp[n][W];
        
          if(wt[n -1] <= W){
            return dp[n][W] = Math.max(val[n - 1] + helper(W - wt[n - 1], wt, val, n -1, dp), helper(W, wt, val, n - 1, dp));
        }
       return dp[n][W] =  helper(W, wt, val, n - 1, dp);
    }
}
