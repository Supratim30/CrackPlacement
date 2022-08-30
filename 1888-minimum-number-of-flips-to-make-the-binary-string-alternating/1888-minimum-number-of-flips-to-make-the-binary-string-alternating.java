class Solution {
    public int minFlips(String s) {
        int n = s.length();
        //use sliding window
        //make two arrays of alternates and compare
        s = s + s;
        char[] p = s.toCharArray();
        
        char[] x = new char[n + n];
        char[] y = new char[n + n];
        
        for(int i = 0; i < n + n; i++){
            x[i] = (i % 2 == 0) ? '1' : '0';
            y[i] = (i % 2 == 0) ? '0' : '1';
        }
        
        int res = Integer.MAX_VALUE;
        int first = 0, second = 0;
        for(int i = 0; i < n + n; i++){
            if(x[i] != p[i]) ++first;
            if(y[i] != p[i]) ++second;
            
            if(i >= n){
                if(x[i - n] != p[i - n]) --first;
                if(y[i - n] != p[i - n]) --second;
            }
            if(i >= n - 1) res = Math.min(res, Math.min(first, second));
        }
       return res; 
    }
}