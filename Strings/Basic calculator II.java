//leetcode 227


class Solution {
    public int calculate(String s) {
        Stack<Integer> st  = new Stack<>();
        int n = s.length();
        int res = 0, num = 0;
        char op = '+';
        for(int i = 0; i < n; i++){
            char c  =  s.charAt(i);
            if(Character.isDigit(c)){
                num *= 10;
                num += c - '0';
            }
            if((!Character.isDigit(c) && c != ' ') || i == n-1){
                if(op == '+') st.push(num);
                else if(op == '-') st.push(-num);
                else if(op=='*') st.push(st.pop() * num);
                else st.push(st.pop()/num);
                
                num  = 0;
                op = c;
            }
        }
        while(!st.isEmpty()) res+= st.pop();
        
        return res;
    }
}
