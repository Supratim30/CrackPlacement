//leetcode 680

class Solution {
    public boolean validPalindrome(String s) {
       int  left = 0, right  = s.length() - 1;
        int c1 = 0, c2 = 0;
        while(left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else{
                left++;
                c1++;
            }
        }
        left = 0; right = s.length() - 1;
         while(left < right){
            if(s.charAt(left) == s.charAt(right)){
                left++;
                right--;
            }else{
                right--;
                c2++;
            }
        }
        if(c1==0||c2==0) return true;
        if(c1==1 || c2==1) return true;
         
        return false;
    }
}
