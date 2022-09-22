class Solution {
    public String reverseWords(String s) {
        String res = "";
        for(String word : s.split(" ")){
            StringBuilder sb=new StringBuilder(word);  
        sb.reverse();  
        res += sb.toString()+" ";  
        }
        return res.trim();
    }
}