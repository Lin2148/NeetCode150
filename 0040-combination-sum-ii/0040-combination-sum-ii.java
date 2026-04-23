class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int idx = 0;
        Arrays.sort(candidates);
        bt(candidates, target, idx, list, ans);
        return ans;
    }

     private void bt (int[] candidate, int target, int idx, ArrayList<Integer> list, List<List<Integer>> ans){
        
        // add list to ans
        if (target == 0){
            ans.add(new ArrayList<>(list));
        }
        //overput cut 
        else if (target < 0){
            return;
        }

        for (int i = idx; i < candidate.length; i++) {
            if (i > idx && candidate[i] == candidate[i - 1]) {
                continue;
            }

            if (candidate[i] > target) break;
            list.add(candidate[i]);
            bt (candidate, target-candidate[i], i+1, list, ans);
            list.remove(list.size()-1);
        }
        return;
    }
}