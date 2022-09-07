// https://www.codingninjas.com/codestudio/problems/ninja-s-training_3621003?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=0

//Memoization
import java.util.*;
public class Solution {
    public static int ninjaTraining(int n, int points[][]) {

        // Write your code here..
        int dp[][] = new int[n][4];
        for (int[] row: dp) {Arrays.fill(row, -1);}
        
         return helper(n - 1, 3, points, dp);
    }
private static int helper(int day, int last, int[][] points, int[][] dp){
    if (dp[day][last] != -1) return dp[day][last];
    
    if(day == 0){
        int maxi = 0;
        for(int i = 0; i <= 2; i++){
            if(i != last)    maxi = Math.max(maxi, points[0][i]);    
        }
        return dp[day][last] = maxi;
    }
    
    int maxi = 0;
    for(int  i = 0; i <= 2; i++){
        if(i != last){
            int point = points[day][i] + helper(day - 1, i, points, dp);
            maxi = Math.max(maxi, point);
        }
    }
    return dp[day][last] = maxi;
}
}
