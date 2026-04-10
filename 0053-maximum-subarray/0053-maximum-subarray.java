class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int curMax = nums[0];
        int length = nums.length;

        for (int i = 1; i < length; i++){
            curMax = Math.max(nums[i], curMax + nums[i]);
            max = Math.max(max, curMax);
        }
        return max;
    }
}