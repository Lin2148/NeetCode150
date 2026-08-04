class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //  放index不是真實溫度  做差值用
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[temperatures.length];
        if (temperatures.length == 1)  {
            return new int[1];
        }
        stack.push(0);
        //第二筆開始比較
        for (int i = 1; i < temperatures.length; i++){
            ans[i] = 0;
            while (!stack.isEmpty()){
                if (temperatures[i] > temperatures[stack.peek()]){
                    int pop = stack.pop();
                    ans[pop] = i-pop;
                } else{
                    break;
                }
            }
            stack.push(i);
        }
        return ans;
    }
}