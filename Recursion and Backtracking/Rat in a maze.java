//gfg: https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1#


// { Driver Code Starts
// Initial Template for Java

import java.util.*;
class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a, n);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++)
                    System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}
// } Driver Code Ends


// User function Template for Java

// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        ArrayList<String> res = new ArrayList<>();
        ArrayList<Character> path = new ArrayList<>();
        
        boolean[][] vis = new boolean[n][n];
        for(boolean[] r: vis) Arrays.fill(r, false);
        if(m[0][0] != 1 || m[n-1][n -1 ] == 0) return res;
        vis[0][0] = true;
        recur(0, 0, m, n, path, res, vis);
        return res;
    }
    
    private static void recur(int row, int col, int[][] arr, int n, ArrayList<Character> path,ArrayList<String> res,boolean[][] vis){
        if(row == n - 1 && col == n - 1){
            String s = "";
            for(Character ch: path) s += ch;
            
            res.add(s);
            return;
        }
        //lexicographically Down Left Right Upward
        // for downward
        if(row + 1 < n && col < n && arr[row + 1][col] == 1 && vis[row + 1][col] == false){
            path.add('D');
            vis[row + 1][col] = true;
            recur(row + 1, col, arr, n, path, res, vis);
            path.remove(path.size() - 1);
            vis[row + 1][col] = false;
        }
        // for left
        if(row>=0 && col -1 >=0 && arr[row][col-1] == 1 && vis[row][col-1] == false)
       {
           path.add('L');
           vis[row][col-1] = true;
           recur(row,col-1,arr,n,path,res,vis);
           path.remove(path.size()-1);
           vis[row][col-1] = false;
       }
        
        // for right
        if(row <= n - 1 && col + 1 <= n-1 && arr[row][col + 1] == 1 && vis[row][col + 1] == false){
            path.add('R');
            vis[row][col + 1] = true;
            recur(row, col + 1, arr, n, path, res, vis);
            path.remove(path.size() - 1);
            vis[row][col + 1] = false;
        }
        // for up
           if(row-1>=0 && col >=0 && arr[row-1][col] == 1 && vis[row-1][col] == false)
       {
           path.add('U');
           vis[row-1][col] = true;
           recur(row-1,col,arr,n,path,res,vis);
           path.remove(path.size()-1);
           vis[row-1][col] = false;
       }
    }
}
