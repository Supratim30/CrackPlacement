class Solution {
//memoization
    public int cherryPickup(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int dp[][][] = new int[r][c][c];
        for (int[][] r1 : dp) {
            for (int[] r2 : r1) Arrays.fill(r2, -1);
        }

        return helper(grid, 0, 0, c - 1, r, c, dp);
    }

    private int helper(int[][] grid, int i, int j1, int j2, int r, int c, int[][][] dp) {
        //base conditions first
        if (j1 < 0 || j1 >= c || j2 < 0 || j2 >= c) return (int) Math.pow(-10, 9);

        if (i == r - 1) {
            if (j1 == j2) return grid[i][j1]; 
            else return grid[i][j1] + grid[i][j2];
        }

        if (dp[i][j1][j2] != -1) return dp[i][j1][j2];

        int max = Integer.MIN_VALUE;
        for (int di = -1; di <= +1; di++) {
            for (int dj = -1; dj <= +1; dj++) {
                int res = 0;
                if (j1 == j2) res = grid[i][j1];
                else res = grid[i][j1] + grid[i][j2];
                
                res += helper(grid, i + 1, j1 + di, j2 + dj, r, c, dp);
                max = Math.max(res, max);
            }
        }
          dp[i][j1][j2] = max;
        return max;
    }
}
