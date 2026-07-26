class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums){
            sum += num;
        }
        if (Math.abs(target) > sum || (sum + target) % 2 != 0) {
            return 0;
        }
        int p = (sum + target) / 2;
        int n = nums.length;

        // change Q to how many ways to full backpack size p
        int[][] dp = new int[n+1][p+1];
        dp[0][0] = 1;

       for (int i = 1; i <= n; i++){
            for (int j = 0; j <= p; j++){
                //不選num
                dp[i][j] = dp[i-1][j]; 
                if (j >= nums[i-1]){
                    dp[i][j] = dp[i][j] + dp[i-1][j-nums[i-1]];
                }
            }
       }
        return dp[n][p];
    }
}
/*
//bt
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int i = 0;
        int cur = 0;
        return bt(nums, i,  target, cur);
    }

    private int bt(int[] nums, int i, int target, int cur){
        if (i == nums.length){
            if (cur == target){
                return 1;
            }
            return 0;
        }
        int pos = bt(nums, i+1, target , cur + nums[i]);
        int neg = bt(nums, i+1, target , cur - nums[i]);
        return pos + neg;
    }
}
*/