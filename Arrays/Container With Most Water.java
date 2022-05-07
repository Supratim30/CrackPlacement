//leetcode 11

class Solution {
    public int maxArea(int[] height) {
      int left = 0;
        int right = height.length - 1;
        
        int maxA  = 0;
        while(left < right){
            int leftH = height[left];
            int rightH = height[right];
            
            int minH = Math.min(leftH, rightH);
            int width = right - left;
            int currA = width * minH;
            maxA = Math.max(currA, maxA);
            
            if(leftH > rightH) right--;
            else if(leftH < rightH) left++;
            else{
              left++;
                right--;
            } 
            }
        return maxA;
    }
}
