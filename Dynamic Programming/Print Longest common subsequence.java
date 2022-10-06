//https://takeuforward.org/data-structure/print-longest-common-subsequence-dp-26/

class Solution
{
    public List<String> all_longest_common_subsequences(String s, String t)
    {
        // Code here
        int n = s.length();
        int m = t.length();
        
        int dp[][] = new int[n + 1][m + 1];
        for(int i = 0; i <= n; i++) dp[i][0] = 0;
        for(int i = 0; i <= m; i++) dp[0][i] = 0;
        
        for(int ind1=1;ind1<=n;ind1++){
        for(int ind2=1;ind2<=m;ind2++){
            if(s.charAt(ind1-1)==t.charAt(ind2-1))
                dp[ind1][ind2] = 1 + dp[ind1-1][ind2-1];
            else
                dp[ind1][ind2] = 0 + Math.max(dp[ind1-1][ind2],dp[ind1][ind2-1]);
        }
    }
    
    int len = dp[n][m];
    int i = n, j = m;
    int idx = len - 1;
    
    String str = "";
    for(int k = 1; k <= len; k++) str += "$";
    
    StringBuilder ss = new StringBuilder(s);
    StringBuilder str2 = new StringBuilder(str);
    
    while(i > 0 && j > 0){
        if(ss.charAt(i - 1) == t.charAt(j - 1)){
            str2.setCharAt(idx,ss.charAt(i-1) ); 
        idx--;
        i--;
        j--;
    }else if(ss.charAt(i - 1) > t.charAt(j - 1)) i--;
    else j--;
    }
    List<String> res = new ArrayList<>();
    res.add(str2.toString());
    return res;
}
    
}
