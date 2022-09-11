class Solution {
    private class Engineer{
        private int effi;
        private int speed;
        public Engineer(int effi, int speed){
            this.effi = effi;
            this.speed = speed;
        }
    }
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        List<Engineer> en = new ArrayList<>();
        for(int i = 0; i < n; i++){
            en.add(new Engineer(efficiency[i], speed[i]));
        }
        en.sort((a,b) -> b.effi - a.effi);
        
        PriorityQueue<Engineer> currTeam = new PriorityQueue<>((a,b) -> a.speed- b.speed);
        
        long teamSpeed= 0;
        long perfo = 0;
        
        for(Engineer newHire : en){
            if(currTeam.size() == k){
                Engineer slowGuy = currTeam.poll();
                teamSpeed -= slowGuy.speed;
            }
            currTeam.add(newHire);
            
            teamSpeed += newHire.speed;
            
            long performanceWithNewGuy = teamSpeed * (long)newHire.effi;
            perfo = Math.max(perfo, performanceWithNewGuy);
            
        }
        return (int)(perfo % 1000000007);
    }
}