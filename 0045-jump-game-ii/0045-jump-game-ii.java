class Solution {
    public int jump(int[] nums) {
        int cnt = 0, curr = 0, far = 0;
        int n = nums.length;

        for (int i = 0; i < n - 1; i++ ){
            far = Math.max(nums[i] + i , far);

            if (i == curr ){
                cnt++;
                curr = far;
                if (curr >= n - 1){
                    break;
                }
            }
        }
        return cnt;
    }
}