//leetcode 40


class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        recur(candidates, target, ans, 0, new ArrayList<>());
        return ans;
    }
    
    private void recur(int[] candidates, int target, List<List<Integer>> ans, int idx, List<Integer> ds){
        if(target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int  i = idx; i < candidates.length; i++){
            if(i > idx && candidates[i] == candidates[i-1]) continue;
            if(candidates[i] > target) break;
            
            ds.add(candidates[i]);
            recur(candidates, target - candidates[i], ans, i +1, ds);
            ds.remove(ds.size()-1);
        }      
    }
}
