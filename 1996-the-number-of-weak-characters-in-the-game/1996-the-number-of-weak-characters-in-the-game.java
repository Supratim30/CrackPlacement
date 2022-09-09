class Solution {

    public int numberOfWeakCharacters(int[][] properties) 
    {
        //sort 0th idx in each 2d array
        //then check for 1st idx
        Arrays.sort(properties, (a, b) -> (a[0] == b[0]) ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));
        
        int weakCounter = 0;
        int n = properties.length;
        
        int maxi = properties[n-1][1];
        for(int i = n - 2; i >=0; i--){
            if(properties[i][1] < maxi) weakCounter++;
            else maxi = properties[i][1];
        }
        return weakCounter;
    }
}
