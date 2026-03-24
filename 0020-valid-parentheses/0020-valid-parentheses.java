class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()){
            if (c == '(') {
                st.push(')');
            }  else if (c == '{'){
                st.push('}');
            }  else if (c == '['){
                st.push(']');
            }  else {  //右括號情況 用前面push的比較
                if (st.isEmpty() || st.pop() != c) {
                    return false; 
                }
            }
        }
        return st.isEmpty();
    }
}