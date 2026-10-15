class StockSpanner {
    Deque<int[]> stack;

    public StockSpanner() {
        this.stack = new ArrayDeque<>();
    }
    
    public int next(int price) {
        if (stack.isEmpty()){
            stack.push(new int[]{price, 1});
            return stack.peek()[1]; 
        }

        if (price < stack.peek()[0]){
            stack.push(new int[]{price, 1});
        } else{
            int tmpSpan = 1;
            // 算span  並把不用的pop掉
            while(!stack.isEmpty() &&stack.peek()[0] <= price){
                int[] pop = stack.pop();
                tmpSpan += pop[1];
            }
            stack.push(new int[]{price, tmpSpan});
        }
        return stack.peek()[1];
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */