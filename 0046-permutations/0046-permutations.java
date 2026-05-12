class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        bt (nums, ans, tmp, used);
        return ans;
    }

    private void bt(int[] nums, List<List<Integer>> ans, List<Integer> tmp, boolean[] used){
        if (tmp.size() == nums.length){
            ans.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 0; i < nums.length; i++){
            if (used[i]) {
                continue;
            }
        used[i] = true;
        tmp.add(nums[i]); 

        bt(nums, ans, tmp, used); 
             
        tmp.remove(tmp.size() - 1); 
        used[i] = false;
        }
    }
}