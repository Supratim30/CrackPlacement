class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sumEven = 0;
        for (int number : nums) {
            if (number % 2 == 0) {
                sumEven += number;
            }
        }
        int[] result = new int[queries.length];
        int numsIndex;
        for (int i = 0; i < queries.length; i++) {
            numsIndex = queries[i][1];
            if (nums[numsIndex] % 2 == 0) {
                sumEven -= nums[numsIndex];
            }
            nums[numsIndex] += queries[i][0];
            if (nums[numsIndex] % 2 == 0) {
                sumEven += nums[numsIndex];
            }
            result[i] = sumEven;
        }
        return result;
    }
}