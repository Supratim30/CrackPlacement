//leetcode 1423

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int windowSize = n-k;
        int windowValue = 0;
        int total = 0;
        
        for(int i : cardPoints) total+=i;
        
        for(int i = 0;i<windowSize;i++) windowValue+=cardPoints[i];
        
        int min = windowValue;
        
        for(int i = windowSize;i<n;i++){
            windowValue= windowValue+cardPoints[i]-cardPoints[i-windowSize];
            min = Math.min(min,windowValue);
        }
        
        return total-min;
    }
}
