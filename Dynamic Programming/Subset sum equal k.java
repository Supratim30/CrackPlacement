// https://www.codingninjas.com/codestudio/problems/subset-sum-equal-to-k_1550954?leftPanelTab=0


//memoization

import java.util.*;
import java.io.*;
public class Solution {
    public static boolean subsetSumToK(int n, int k, int arr[]){
        // Write your code here.
        int[][] dp = new int[n][k + 1];
        for(int[] row : dp) Arrays.fill(row, -1);
        return helper(n - 1, k, dp, arr);
    }
    public static boolean helper(int idx, int target, int[][] dp, int[] arr){
        if(target == 0) return true;
        if(idx == 0) return arr[idx] == target;
        
        //not take
        if(dp[idx][target] != -1) return dp[idx][target] == 0 ? false: true;
        
        boolean notTake = helper(idx - 1, target, dp, arr);
        
        boolean take = false;
        if(arr[idx] <= target){
            take = helper(idx - 1, target - arr[idx], dp, arr);
            dp[idx][target] = take || notTake ? 1 : 0;
        }
        return notTake || take;
    }
}
