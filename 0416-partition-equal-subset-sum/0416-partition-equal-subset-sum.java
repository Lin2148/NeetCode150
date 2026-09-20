class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        
        for (int i : nums){
            sum+=i;
        }
        if (sum%2 == 1){
            return false;
        }

        int target = sum/2;
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        for (int i : nums){
            if (i > target){
                return false;
            }
            for (int j = target; j > i; j--){
                if(dp[j-i]){
                    dp[j]=true;
                }
            }
            dp[i]=true;
            
        }
        return dp[target];
    }
}