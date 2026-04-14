class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int idx = 0;

        bt(nums, 0, list, ans);
        return ans;
    }

    private void bt (int[] nums, int idx, ArrayList<Integer> list, List<List<Integer>> ans){
        ans.add(new ArrayList<>(list));
        for (int i = idx; i < nums.length; i++) {
            list.add(nums[i]);
            bt (nums, i+1 , list, ans);
            list.remove(list.size()-1);
        }
        
    }
}