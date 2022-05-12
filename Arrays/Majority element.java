//leetcode 169

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>();
        int count  = 0;
        for(int num:nums){
            if(!m.containsKey(num)) m.put(num, 1);
            else m.put(num, m.get(num) + 1);
            
            if(m.get(num) > nums.length / 2){
                count = num;
                break;
            }
        }
        return count;
    }
}
