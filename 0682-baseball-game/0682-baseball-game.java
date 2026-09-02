class Solution {
    public int calPoints(String[] operations) {
        int ans = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (String s : operations){
             switch (s){
                case "D":
                {
                    int num = stack.peek();
                    stack.push(num*2);
                    ans+=num*2;
                    break;
                }
                case "C":
                {
                    int c = stack.pop();
                    ans-=c;
                    break;
                }
                case "+":
                {
                    int a = stack.pop();
                    int b = stack.peek();
                    stack.push(a);
                    stack.push(a+b);
                    ans+=(a+b);
                    break;
                }
                default:
                {
                    int num = Integer.parseInt(s);
                    stack.push(num);
                    ans+=num;
                }   
             }
        }
        return ans;
    }
}