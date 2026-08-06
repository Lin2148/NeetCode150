class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        
        Arrays.sort(nums);

        int idx = 0;
        bt(ans,list,idx,nums);
        return ans;
    }

    private void bt(List<List<Integer>> ans, List<Integer> list, int idx, int[] nums){
        ans.add(new ArrayList<>(list));
        for (int i = idx; i < nums.length; i++){
            // i=0情況 if不會走到右邊out of bound
            if (i > idx && nums[i] == nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            bt(ans, list, i+1, nums);
            list.remove(list.size()-1);

        }
    } 
}