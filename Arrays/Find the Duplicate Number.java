//leetcode 287

class Solution {
    public int findDuplicate(int[] nums) {
        int val = 0;
        for(int i = 0; i < nums.length; i++){
            val = Math.abs(nums[i]);
            val--;
            if(nums[val] < 0) return Math.abs(nums[i]);
            else nums[val] = -nums[val];
        }
        return -1;
    }
}
