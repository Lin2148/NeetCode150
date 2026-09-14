class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i : asteroids){
            boolean alive =true;

            if (i>0){
                stack.push(i);
            } else{
                while (alive && !stack.isEmpty() && stack.peek() > 0){
                    if (stack.peek() < -i){
                        stack.pop();
                    } else if (stack.peek() == -i){
                        stack.pop();
                        alive = false;
                    } else{
                        alive = false;
                    }
                }
                if (alive){
                    stack.push(i);
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