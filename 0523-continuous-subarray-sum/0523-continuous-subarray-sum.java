class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Set<Integer> modS  = new HashSet();
        int currS = 0, prevS  = 0;
        
        for(int n : nums){
            currS += n;
            
            if(modS.contains(currS % k)) return true;
            currS %= k;
            modS.add(prevS);
            prevS = currS;
        }
        return false;
    }
}