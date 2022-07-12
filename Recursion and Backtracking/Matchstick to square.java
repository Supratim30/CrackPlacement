//leetcode 473

class Solution {

    // TC : O(4^N)
    public boolean makesquare(int[] nums) {
        if (nums.length < 4) return false;

        int perimeter = 0;
        for (int el : nums)  {
            perimeter += el;
        }

        if (perimeter % 4 != 0) return false;

        Arrays.sort(nums);
        int side = perimeter / 4;
        int[]  sides = new int[] {side, side, side, side};
reverse(nums);
        return makesquareHelper(nums, 0, sides);
    }

    private boolean makesquareHelper(int[] nums, int i, int[] sides) {
        if(i == nums.length) {

            if(sides[0] == 0 && sides[1] == 0 && sides[2] == 0 && sides[3] == 0){
                return true;
            } else{
                return false;
            }
        }


        for (int j = 0; j < 4; j++) {
            if (nums[i] > sides[j]) continue;
            sides[j] -= nums[i];
            if (makesquareHelper(nums, i + 1, sides)) return true;
            sides[j] += nums[i];
        }

        return false;
    }
    void reverse(int[] nums){
        int i = 0;
        int j = nums.length - 1;
        while(i <= j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}
