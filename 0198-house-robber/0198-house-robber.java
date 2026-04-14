class Solution {
    public int rob(int[] nums) {
        int prev2 = 0, prev1 = 0;
        for (int i = 0; i < nums.length; i++){
            int cur = Math.max(prev1, nums[i] + prev2);
            prev2 = prev1;
            prev1 = cur; 
        }
    return Math.max(prev2, prev1);
    } 
}