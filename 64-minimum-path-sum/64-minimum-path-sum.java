class Solution {
    //memoize
    int[][] dp;
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n];
        
        for(int[] a: dp) Arrays.fill(a, -1);
        return helper(m - 1, n - 1, grid);
    }
    private int helper(int i, int j, int[][] grid){
        if(i == 0 & j == 0) return grid[0][0];
        if(i < 0 || j < 0) return (int)Math.pow(10,9);
        
        if(dp[i][j] != -1) return dp[i][j];
        
        int up = grid[i][j] + helper(i - 1, j, grid);
        int left = grid[i][j] + helper(i, j - 1, grid);
        
        return dp[i][j] = Math.min(up, left);
    }
}