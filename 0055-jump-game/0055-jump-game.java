class Solution {
    public boolean canJump(int[] nums) {
        int reach = 0;
        if (nums.length==1) return true;

        for (int i = 0; i < nums.length; i++ ){
            if (i > reach) return false;

            reach = Math.max(nums[i] + i, reach);
        
            if (reach >= nums.length) return true;
        }
    return true;
    }
}