class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int score = 0;
        int maxS = 0;
        Arrays.sort(tokens);
        
        int left = 0;
        int right = tokens.length - 1;
        
        while(left <= right){
            if(power >= tokens[left]){
                power -= tokens[left++];
                score++;
                maxS = Math.max(maxS, score);
            }else if(score > 0){
                power += tokens[right--];
                score--;
            } else break;
        }
        return maxS;
    }
}


