class Solution {
    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        Arrays.sort(changed);
        
        int[] res = new int[n / 2];
        Queue<Integer> q = new LinkedList<>();
        int i = 0;
        
        for(int nums : changed){
            if(!q.isEmpty() && nums == q.peek()) q.poll();
            else{
                if(i == res.length) return new int[0];
                q.offer(nums * 2);
                res[i++] = nums;
            }
        }
        return q.isEmpty() ? res : new int[0];
    }
}