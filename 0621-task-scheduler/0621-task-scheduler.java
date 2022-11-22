class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] charMap = new int[26];
        for(char c : tasks) charMap[c - 'A']++;
        
        Arrays.sort(charMap);
        int maxV = charMap[25] - 1;
        int idleSlots = maxV * n;
        
        for(int i = 24; i >= 0; i--){
            idleSlots -= Math.min(charMap[i], maxV);
        }
        
        return idleSlots > 0 ? idleSlots + tasks.length : tasks.length;
    }
}