class Solution {
//using tabulation approach of LCS
    public int longestPalindromeSubseq(String s) {
        StringBuilder str = new StringBuilder(s);
        str.reverse();
        String s2 = str.toString();
        int[][] dp = new int[s.length() + 1][s.length() + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
        if (s.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = 1 + dp[i - 1][j - 1];
        else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[s.length()][s.length()];
    }
}
