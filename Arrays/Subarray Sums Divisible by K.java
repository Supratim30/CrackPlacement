//leetcode 974

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        m.put(0, 1);
        
        int runningSum = 0;
        int count = 0;
        
        for(int i = 0; i < nums.length; i++){
            runningSum += nums[i];
            int rem = runningSum % k;
            if(rem < 0) rem += k;
            if(m.containsKey(rem)){
                count += m.get(rem);
            }
                m.put(rem, m.getOrDefault(rem, 0) + 1);
            
        }
        return count;
    }
}
