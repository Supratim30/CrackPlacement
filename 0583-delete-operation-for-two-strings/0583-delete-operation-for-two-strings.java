class Solution {
    public int minDistance(String word1, String word2) {
         if(word1.length() < word2.length()) {
        String tmp = word1;
        word1 = word2;
        word2 = tmp;
    }
    int[][] dp = new int[2][word2.length() + 1];
    for (int i = 0; i <= word1.length(); i++) 
        for (int j = 0; j <= word2.length(); j++) 
            if (i == 0 || j == 0) 
                dp[i & 1][j] = i + j;
            else if (word1.charAt(i - 1) == word2.charAt(j - 1)) 
                dp[i & 1][j] = dp[(i - 1) & 1][j - 1];
            else 
                dp[i & 1][j] = 1 + Math.min(dp[(i - 1) & 1][j], dp[i & 1][j - 1]);
    
    return dp[word1.length() & 1][word2.length()];
    }
}