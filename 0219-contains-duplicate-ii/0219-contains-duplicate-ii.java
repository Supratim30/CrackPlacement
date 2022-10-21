class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k == 0) return false; // edge case

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int integer = nums[i];
            if (map.containsKey(integer) && i - map.get(integer) <= k) return true; // checking the given condition

            map.put(integer, i);
        }
        return false;
    }
}
