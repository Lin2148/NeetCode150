class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target + 1];
        Arrays.fill(memo, -1);
        return bt(nums, target, memo);

    }
    private int bt(int[] nums, int target, int[] memo){
        if (target == 0){
            return 1;
        }
        if (memo[target] != -1){
            return memo[target];
        }
        int cnt = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] <= target){
                cnt += bt(nums, target - nums[i], memo);
            }
        }
        memo[target] = cnt;
        return cnt;
    }
}