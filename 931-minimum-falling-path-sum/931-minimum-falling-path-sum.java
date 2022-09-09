class Solution {

    public int minFallingPathSum(int[][] matrix) {
        //top down
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];
        for (int[] arr : dp) Arrays.fill(arr, -1);
        int mini = Integer.MAX_VALUE;

        for (int j = 0; j < m; j++) {
            int ans = helper(n - 1, j, m, dp, matrix);
            mini = Math.min(mini, ans);
        }
        return mini;
    }

    private int helper(int i, int j, int m, int[][] dp, int[][] matrix) {
//base conditions
        if (j < 0 || j >= m) return (int) Math.pow(10, 9);
        if (i == 0) return matrix[0][j];
        
        
        if (dp[i][j] != -1) return dp[i][j];
        int up = matrix[i][j] + helper(i - 1, j, m, dp, matrix);
        int leftD = matrix[i][j] + helper(i - 1, j - 1, m, dp, matrix);
        int rightD = matrix[i][j] + helper(i - 1, j + 1, m, dp, matrix);

        return dp[i][j] = Math.min(up, Math.min(leftD, rightD));
    }
}
