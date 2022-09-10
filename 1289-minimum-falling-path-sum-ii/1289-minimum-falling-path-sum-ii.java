class Solution {
    int[][] dp;

    public int minFallingPathSum(int[][] grid) {
        if (grid.length == 1) return grid[0][0];

        int n = grid.length;
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) dp[i][j] = -1;
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) min = Math.min(min, helper(grid, 0, j));

        return min;
    }

    public int helper(int[][] grid, int i, int j) {
        if (i >= grid.length - 1) return dp[i][j] = grid[i][j];

        if (dp[i][j] != -1) return dp[i][j];

        int mini = Integer.MAX_VALUE;

        for (int k = 0; k < grid[0].length; k++) {
            if (k != j) mini = Math.min(mini, helper(grid, i + 1, k));
        }

        return dp[i][j] = mini + grid[i][j];
    }
}
