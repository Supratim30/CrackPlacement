//leetcode 20

class Solution {
    public boolean isValid(String s) {
        if(s.length()%2 != 0) return false;
        
        Stack<Character> paren = new Stack<>();
        //can use ASCII in solving the problem
        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if(!paren.isEmpty() && (paren.peek()== c-1 || paren.peek() == c-2)){
                paren.pop();
            }else{
                paren.push(c);
            }
        }
        if(paren.isEmpty()) return true;
        return false;
    }
}
