class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n==0) return 0;
        if (n==1) return nums[0];
        return Math.max(dp(nums, 0, n-2),dp(nums, 1, n-1));
        
    } 

    private int dp (int[] nums, int s, int e){
        int prev2 = 0, prev1 = 0;
        for (int i = s; i <= e; i++){
            int cur = Math.max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = cur; 
        }
        return Math.max(prev2, prev1);
    }
}