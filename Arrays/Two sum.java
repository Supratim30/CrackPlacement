//leetcode 01

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            Integer requiredNum = (Integer)(target - nums[i]);
            if(map.containsKey(requiredNum)){
                int toReturn[] = {map.get(requiredNum), i};
                return toReturn;
            }

            map.put(nums[i], i);
        }
        return null;
    }
}
