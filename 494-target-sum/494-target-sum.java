class Solution {
public int findTargetSumWays(int[] nums, int target) {
     int n=nums.length;
    int sum=0;
    
    for(int num : nums) sum += num;
    
   if((sum-target)%2==1 || (target>sum)) return 0;
    
    sum=(sum+target)/2;
    if(sum<0) return 0;
    return getCount(nums,sum,nums.length);
}
public int getCount(int[] nums,int target,int size){
    int[][] arr = new int[size+1][target+1];
    for(int i=0;i<size+1;i++){
        for(int j=0;j<target+1;j++){
        if(i==0) arr[i][j]=0;
        if(j==0) arr[i][j]=1;
    } 
    }
    
    for(int i=1;i<size+1;i++){
        for(int j=0;j<target+1;j++){
        if(nums[i-1]>j) arr[i][j]=arr[i-1][j];
        else arr[i][j]=arr[i-1][j - nums[i-1]]+arr[i-1][j];
    } 
    }
    return arr[size][target];
}
}