class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        
        return Math.max( helper2(nums,0,n-2), helper2(nums, 1, n-1) );
    }
    
    public int helper2(int[] houses, int start, int end){
        int prev = houses[start];
        int prev2 = 0;
        for(int i=start+1; i<=end; i++){

            int pick = houses[i];
            if(i>1) pick = pick + prev2;
            int notPick = prev;

            int currI = Math.max(pick,notPick);
            
            prev2 = prev;
            prev = currI;
        }
        return prev;
    }
    
}