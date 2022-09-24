class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        return target(nums, target, 0);
    }

    private int target(int[] nums, int target, int index) {
        if (index == nums.length) return target == 0 ? 1 : 0;
        return target(nums, target + nums[index], index + 1) + target(nums, target - nums[index], index + 1);
    }
}
