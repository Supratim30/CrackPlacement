//leetcode 78

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        recur(0, nums, ans, ds);
        return ans;
    }
    public void recur(int i,int [] nums,List<List<Integer>>ans,List<Integer>ds) {
        if(i == nums.length){
            ans.add(ds);
            return;
        }
        ds.add(nums[i]);
        recur(i+1, nums, ans, ds);
        ds.remove(ds.size()-1);
        recur(i+1, nums, ans, ds);
    }
}
