//leetcode 77

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        recur(ans, ds, n, k, 1);
        return ans;
    }
    
    private static void recur(List<List<Integer>> ans, List<Integer> ds, int n, int k, int idx){
        if(ds.size() == k){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = idx; i <= n; i++){
        ds.add(i);
        recur(ans, ds, n, k, i + 1);
            ds.remove(ds.size() - 1);
        }
    }
}
