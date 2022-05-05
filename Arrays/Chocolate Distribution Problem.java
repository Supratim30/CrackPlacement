//gfg : https://practice.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1


class Solution
{
    public long findMinDiff (ArrayList<Long> a, long n, long m)
    {
        // your code here
        
        Collections.sort(a);   
       long ans =  Integer.MAX_VALUE;
       
       for(int i=0;i<=(int)n-m;i++){
           long minw = a.get(i);
           long maxw = a.get(i+(int)m-1);
           long gap = maxw-minw;
           
           
           if(gap<ans){
               ans= gap;
           }
       }
       return ans;
    }
}
