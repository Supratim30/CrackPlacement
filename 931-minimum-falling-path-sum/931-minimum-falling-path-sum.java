class Solution {
    public int minFallingPathSum(int[][] matrix) {

    int min = solution(matrix, matrix.length - 1, matrix[0].length - 1);
    return min;
}

public static int solution(int[][] board, int lastrow, int lastcol){

    
    int dp[][] = new int[lastrow+1][lastcol+1];
    
    //tabulation
    for(int col = 0; col <= lastcol; col++){
        dp[lastrow][col] = board[lastrow][col];
    }
    
    for(int i = lastrow - 1; i >= 0; i--){
        for(int j = lastcol; j >= 0; j--){
            if(j == lastcol){
                dp[i][j] = Math.min(dp[i+1][j-1],dp[i+1][j]) + board[i][j];
            } else if(j == 0){
                dp[i][j] = Math.min(dp[i+1][j+1],dp[i+1][j]) + board[i][j];    
            } else {
                dp[i][j] = Math.min(dp[i+1][j+1],(Math.min(dp[i+1][j-1],dp[i+1][j]))) + board[i][j];
            }
        }
    }
    
    int min = Integer.MAX_VALUE;
    for(int j = 0; j <= lastcol; j++){
        if(dp[0][j] < min){
            min = dp[0][j];
        }
    }
    return min;
}
}