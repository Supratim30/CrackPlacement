//leetcode 151

class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] str = s.split("\\s+");
        Stack<String> st = new Stack<>();
        String ans = "";
        for(String c : str){
            st.push(c);
        }
        
        while(!st.isEmpty()){
            ans += st.pop();
            ans += " ";
        }
        
        ans = ans.trim();
        return ans;
    }
}
