class Solution {

    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) totalSum += nums[i];

        if (totalSum % 2 == 1) return false;
        int target = totalSum / 2;
int n = nums.length;
        int[][] dp = new int[n][target + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return helper(nums, dp, target, n - 1);
    }

    private boolean helper(int[] nums, int[][] dp, int target, int idx ) {
        if (target == 0) return true;

        if (idx == 0) return nums[0] == target;

        if (dp[idx][target] != -1) return dp[idx][target] == 0 ? false : true;

        boolean notTaken = helper(nums, dp, target, idx - 1);

        boolean taken = false;
        if (nums[idx] <= target) taken = helper(nums, dp, target - nums[idx], idx - 1);
        dp[idx][target] = notTaken || taken ? 1 : 0;
        return notTaken || taken;
    }
}
