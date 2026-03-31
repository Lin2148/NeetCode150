class Solution {
    public int search(int[] nums, int target) {
        int min=0;
        int max=nums.length - 1;
        while (min <= max){
            int look = (min + max) / 2;

            if (nums[look] == target) return look;
            else if (nums[look] > target) max = look - 1;
            else min = look + 1;
        }
        return -1;
    }
}