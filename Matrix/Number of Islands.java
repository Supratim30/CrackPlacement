//leetcode 200

class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m  = grid[0].length;
        int count = 0;
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j]=='1'){
                    DFSCall(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    public void DFSCall(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') return;
        
        grid[i][j] = '0';
        DFSCall(grid, i - 1, j);
        DFSCall(grid, i, j+1);
        DFSCall(grid, i + 1, j);
        DFSCall(grid, i, j - 1);

    }
}
