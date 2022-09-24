class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        int ans = allsets(nums, 0, 0, target, 0);
        return ans;
    }

    public static int allsets(int[] nums, int idx, int sum, int target, int count) {
        if (idx == nums.length) {
            if (sum == target) {
                count++;
            }
            return count;
        }

        int ansp = allsets(nums, idx + 1, sum + nums[idx], target, count);

        int ansm = allsets(nums, idx + 1, sum - nums[idx], target, count);

        return ansp + ansm;
    }
}
