class Solution {
    public int subsetXORSum(int[] nums) {
        return bt(nums, 0, 0);
    }


    private int bt(int[] nums, int idx, int curXor){
        if (idx ==nums.length ){
            return curXor;
        }

        return bt(nums,idx+1,curXor ^ nums[idx]) + bt(nums,idx+1,curXor);
    }
}