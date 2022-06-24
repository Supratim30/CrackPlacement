//leetcode 39


class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        recur(candidates, target, ans, 0, new ArrayList<>());
        return ans;
    }
    
    private void recur(int[] candidates, int target, List<List<Integer>> ans, int i, List<Integer> ds){
        if(i == candidates.length){
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
                            return;

        }
        
        if(target >= candidates[i]){
            ds.add(candidates[i]);
            recur(candidates, target - candidates[i], ans, i, ds);
            ds.remove(ds.size() - 1);
        }
        recur(candidates, target, ans, i + 1, ds);
    }
}
