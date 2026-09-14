class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i : asteroids){
            if (i>0){
                stack.push(i);
            } else{
                int remain=i;
                do
                {
                    if (!stack.isEmpty() && stack.peek() > 0){
                        int prev = stack.pop();
                        if (Math.abs(i) > prev) {
                            remain = i;      
                        } else if (Math.abs(i) == prev) {
                            remain = 0;       
                        } else {
                            remain = prev;    
                        }
                    }
                } while (remain < 0 && !stack.isEmpty() && stack.peek()>0);
                if (remain != 0){
                    stack.push(remain);
                }
            }
        }

        int len = stack.size();
        int[] ans = new int[len];
        for (int i=len-1; i >= 0; i--){
            ans[i] = stack.pop();
        }
        return ans;
    }
}