//leetcode 980

class Solution {
    public int uniquePathsIII(int[][] grid) {
        int zeroes = 0, sr = 0, sc = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0) zeroes++;
                if(grid[i][j] == 1){
                    sr = i;
                    sc = j;
                }
            }
        }
        return dfs(grid, sr, sc, zeroes);
    }
    private int dfs(int[][] grid, int x, int y, int zeroC){
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == -1) return 0;
        if (grid[x][y] == 2) return zeroC == -1 ? 1 : 0;
        
        grid[x][y] = -1;
        zeroC -= 1;
        int totalPaths = dfs(grid, x + 1, y, zeroC) + dfs(grid, x, y + 1, zeroC) + dfs(grid, x - 1, y, zeroC) + dfs(grid, x, y - 1, zeroC);
        grid[x][y] = 1;
        zeroC += 1;
        
        return totalPaths;
    }
}
