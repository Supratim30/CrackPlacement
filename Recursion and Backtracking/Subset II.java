//leetcode 90

class Solution {
public void recur(int i,int [] nums,List<List<Integer>> ans, List<Integer>ds){
    ans.add(new ArrayList <>(ds));
    for(int id=i;id<nums.length;id++){
        if(id!=i&&nums[id]==nums[id-1]) continue;
        ds.add(nums[id]);
        recur(id+1,nums,ans,ds);
        ds.remove(ds.size()-1);
    }
}
public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> ans = new ArrayList<>();
    recur(0,nums,ans,new ArrayList<Integer>());
    return ans;
    }
}
