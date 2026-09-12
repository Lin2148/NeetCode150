class Solution {
    public int[] getConcatenation(int[] nums) {
        int len = nums.length;
        int[] ans = new int[2*len];

        System.arraycopy(nums, 0, ans, 0, len);
        System.arraycopy(nums, 0, ans, len, len);

        return ans;
    }
}