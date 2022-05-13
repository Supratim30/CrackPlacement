//leetcode 289

//brute-force Approach: 1

class Solution {
    public void gameOfLife(int[][] board) {
        int R = board.length;
        int C = board[0].length;
        
        int[][] copy = new int[R][C];
        for(int i = 0;i < R; i++){
            for(int j = 0; j < C; j++){
                copy[i][j] = board[i][j];
            }
        }
        
        int[] dx = {1,1,0,-1,-1,-1,0,1};
        int[] dy = {0,1,1,1,0,-1,-1,-1};
        
        for(int i = 0;i < R; i++){
            for(int j = 0; j < C; j++){
             int liveCount = 0;
             for(int k = 0; k < 8; k++){
    if(isSafe(i + dx[k], j + dy[k], R, C) && copy[i + dx[k]][j + dy[k]]==1) liveCount++;
             }   
                 if(copy[i][j] == 0 && liveCount == 3 ) board[i][j] = 1;
                 if(board[i][j] == 1 && (liveCount < 2 || liveCount > 3)) board[i][j] = 0;
             
            }
        }
        
    }
    private boolean isSafe(int x, int y, int R, int C){
        return (x>=0 && x < R && y>=0 && y < C);
    }
}


// in place Appraoch: 2

class Solution {
    public void gameOfLife(int[][] board) {
        int R = board.length;
        int C = board[0].length;
        
        
        int[] dx = {1,1,0,-1,-1,-1,0,1};
        int[] dy = {0,1,1,1,0,-1,-1,-1};
        
        for(int i = 0;i < R; i++){
            for(int j = 0; j < C; j++){
             int liveCount = 0;
             for(int k = 0; k < 8; k++){
    if(isSafe(i + dx[k], j + dy[k], R, C) && Math.abs(board[i + dx[k]][j + dy[k]])==1) liveCount++;
             }   
                 if(board[i][j] == 0 && liveCount == 3 ) board[i][j] = 2;
                 if(board[i][j] == 1 && (liveCount < 2 || liveCount > 3)) board[i][j] = -1;
             
            }
        }
        for(int i = 0;i < R; i++){
            for(int j = 0; j < C; j++) board[i][j] = board[i][j] > 0 ? 1: 0;
        }
    }
    private boolean isSafe(int x, int y, int R, int C){
        return (x>=0 && x < R && y>=0 && y < C);
    }
}

