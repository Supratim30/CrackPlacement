//leeetcode 76

class Solution {
    public String minWindow(String s, String t) {
       String ans  = "";
    HashMap<Character, Integer> tmap = new HashMap<>();
        for(int  i = 0; i < t.length(); i++){
            char ch  = t.charAt(i);
            tmap.put(ch, tmap.getOrDefault(ch, 0) + 1);
        }
        int mcnt = 0;
        int dmcnt = t.length();
        
        HashMap<Character, Integer> smap = new HashMap<>();
        int i = -1;
        int j = -1;
        
        while(true){
            boolean f1 = false;
            boolean f2 = false;
            
            //acquire
            while(i < s.length() -1 && mcnt < dmcnt){
                i++;
                char ch = s.charAt(i);
                smap.put(ch, smap.getOrDefault(ch, 0) + 1);
                
                if(smap.getOrDefault(ch, 0) <= tmap.getOrDefault(ch, 0)) mcnt++;
                f1 = true;
                }
            while(j < i && mcnt == dmcnt){
                //capture answer
                String pans = s.substring(j+1, i+1);
                if(ans.length() == 0 || pans.length() < ans.length()) ans = pans;
                //release
                j++;
                char ch = s.charAt(j);
                if(smap.get(ch) == 1) smap.remove(ch);
                else smap.put(ch, smap.get(ch) - 1);
                
                if(smap.getOrDefault(ch, 0) < tmap.getOrDefault(ch, 0)) mcnt--;
                
                f2 = true;
            }
            if(f1 == false && f2 == false) break;
        }
        return ans;
    }
}
