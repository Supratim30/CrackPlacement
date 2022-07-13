//leetcode 47

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> track = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        backtrack(nums,res, track, vis, 0);
        return res;
    }
    private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> track, boolean[] vis, int idx){
        if(track.size() == nums.length){
            res.add(new ArrayList<>(track));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(vis[i]) continue;
            if(i != 0 && nums[i] == nums[i-1] && !vis[i-1]) continue;
            track.add(nums[i]);
            vis[i] = true;
            backtrack(nums, res, track, vis, i + 1);
            vis[i] = false;
            track.remove(track.size() - 1);
        }
    }
}
