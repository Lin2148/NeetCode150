class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int top = cost.length + 1;
        int[] dp = new int[top];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i < top; i++){
            dp[i] = Math.min(cost[i-1] + dp[i-1], cost[i-2] + dp[i-2]);
        }
    return dp[top - 1];
    }
}