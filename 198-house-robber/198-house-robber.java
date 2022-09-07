class Solution {
    public int rob(int[] nums) {
        //pick/not pick
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        
        if(n == 1) return dp[0];
        if(n ==  2) return Math.max(nums[0], nums[1]);
        dp[1] = Math.max(nums[0], nums[1]);
        
        for(int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i -  2] + nums[i], dp[i - 1]);
        }
        return dp[n - 1];
        }
}