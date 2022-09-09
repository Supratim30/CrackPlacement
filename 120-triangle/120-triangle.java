class Solution {
    //memoization
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(0).size();
        
        int[][] dp = new int[n][n];
        for(int[] row : dp) Arrays.fill(row, - 1);
        
        return helper(0, 0, triangle, dp);
    }
    private int helper(int i, int j, List<List<Integer>> triangle, int[][] dp){
        if(dp[i][j] != -1) return dp[i][j];
        if(i == triangle.size() - 1) return triangle.get(i).get(j);
        
        
        int down = triangle.get(i).get(j) + helper(i + 1, j, triangle, dp);
        int diagonal = triangle.get(i).get(j) + helper(i + 1, j + 1, triangle, dp);
            
            return dp[i][j] = Math.min(down, diagonal);
    }
}