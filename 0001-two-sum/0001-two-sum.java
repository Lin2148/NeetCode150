class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n= nums.length;
        int[] ans = new int[2];
        for (int i = 0; i < n; i++){
            int minus = target - nums[i];
            boolean find = map.containsKey(minus);
            if (find){
                ans[0] = map.get(minus);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
}