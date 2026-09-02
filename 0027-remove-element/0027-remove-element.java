class Solution {
    public int removeElement(int[] nums, int val) {
        int idx = 0;
        for (int i : nums){
            if (i != val){
                nums[idx] = i;
                idx++;
            }
        }
        return idx;
    }
}