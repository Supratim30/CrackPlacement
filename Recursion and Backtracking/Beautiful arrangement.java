//leetcode 526


class Solution {
    int count = 0;
    public int countArrangement(int n) {
        boolean[] vis = new boolean[n + 1];
        backtrack(n, vis, 1);
        return count;
    }
    private void backtrack(int n, boolean[] vis, int pos){
        if(pos > n) count++;
        else{
            for(int i = 1; i <= n; i++){
                if(vis[i] == false && (pos%i==0 || i%pos==0)){
                    vis[i] = true;
                    backtrack(n, vis, pos + 1);
                    vis[i] = false;
                }
            }
        }
    }
}
