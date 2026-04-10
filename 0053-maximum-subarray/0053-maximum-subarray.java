class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int length = nums.length;
        int[] curMax = new int[length];
        curMax[0] = nums[0];
        for (int i = 1; i < length; i++){
            if (curMax[i-1] + nums[i] >= nums[i]){
                curMax[i] = curMax[i-1] + nums[i]; 
                if (curMax[i] > max){
                    max = curMax[i];
                }
            }
            else {
                curMax[i] = nums[i];
                max = Math.max(max, curMax[i]);
            }
        }
        return max;
    }
}