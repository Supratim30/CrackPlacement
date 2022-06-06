//leetcode 22


class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        getParen("(", 1, 0, res, n);
        return res;
    }
    
    void getParen(String paren, int o, int c, List<String> res, int n){
        
        if(paren.length() == 2*n){
            res.add(paren);
            return;
        } 
        
        if(o < n) getParen(paren + "(", o+1, c, res, n);
        if(c < o) getParen(paren + ")", o, c+1, res, n);
    }
}
