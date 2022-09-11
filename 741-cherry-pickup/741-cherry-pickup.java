class Solution {

    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int dp[][][][] = new int[n][n][n][n];
        int ans = f(0, 0, 0, 0, grid, dp);
        if (ans < 0)   return 0;
        
        return ans;
    }

    public int f(int r1, int c1, int r2, int c2, int grid[][], int dp[][][][]) {
        if (r1 >= grid.length || r2 >= grid.length || c1 >= grid[0].length || c2 >= grid[0].length || grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return Integer.MIN_VALUE;
        }
        if (r1 == grid.length - 1 && c1 == grid[0].length - 1) {
            return grid[r1][c1];
        }
        if (dp[r1][c1][r2][c2] != 0) {
            return dp[r1][c1][r2][c2];
        }
        int cherry = 0;
        if (r1 == r2 && c1 == c2) {
            cherry += grid[r1][c1];
        } else {
            cherry += grid[r1][c1] + grid[r2][c2];
        }

        int f1 = f(r1 + 1, c1, r2 + 1, c2, grid, dp);
        int f2 = f(r1, c1 + 1, r2, c2 + 1, grid, dp);
        int f3 = f(r1 + 1, c1, r2, c2 + 1, grid, dp);
        int f4 = f(r1, c1 + 1, r2 + 1, c2, grid, dp);
        cherry += Math.max(Math.max(f1, f2), Math.max(f3, f4));
        return dp[r1][c1][r2][c2] = cherry;
    }
}
