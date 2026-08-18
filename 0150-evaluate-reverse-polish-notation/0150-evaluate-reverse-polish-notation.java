class Solution {
    public int evalRPN(String[] tokens) {
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (String s:tokens){
            if (s.equals("+")){
                ans = stack.pop()+stack.pop();
                stack.push(ans);
                System.out.println(ans);
            } else if (s.equals("-")){
                ans = -stack.pop()+stack.pop();
                stack.push(ans);
            } else if(s.equals("*")){
                ans = stack.pop()*stack.pop();
                stack.push(ans);
            } else if (s.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                ans = b/a;
                stack.push(ans);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.peek();
    }
}