class Solution {
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int compare = nums[0];
        for (int i : nums){
            if (i != compare){
                cnt--;
                if (cnt == -1){
                    compare = i;
                    cnt = 1;
                }
            } else{
                cnt++;
            }
        }
        return compare;
    }
}