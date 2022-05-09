//leetcode 18


class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        
        HashSet<ArrayList<Integer>> res = new HashSet<>();
        for(int i = 0; i < n - 3; i++){
            for(int j = i + 1; j < n - 2; j++){
                int left = j+1;
                int right = n - 1;
                
                int a = nums[i];
                int b = nums[j];
                while(left < right){
                    int c = nums[left];
                    int d = nums[right];
                    
                    int sum = a + b + c + d;
                    
                    if(sum == target){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(a);
                                                list.add(b);
                        list.add(c);
                        list.add(d);
res.add(list);
                        left++;
                    }
                    else if(sum > target) right--;
                    else left++;
                    
                }
            }
        }
        List<List<Integer>> ans  = new ArrayList<>();
        ans.addAll(res);
        return ans;
    }
}
