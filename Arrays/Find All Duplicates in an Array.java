//leetcode 442

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
       Map<Integer, Integer> hmap = new HashMap<>();
List list = new ArrayList<>(nums.length);
for(int i=0;i<nums.length;i++){
if(hmap.containsKey(nums[i])){
int value=hmap.get(nums[i]);
hmap.replace(nums[i],value+1);
if(hmap.get(nums[i])==2){
list.add(nums[i]);
}
}
hmap.put(nums[i],1);
}
return list; 
    }
}
