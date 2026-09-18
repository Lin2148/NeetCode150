class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        bt(1, n, k, ans, cur);

        return ans;
    }

    private void bt(int s, int n, int k, List<List<Integer>> ans, List<Integer> cur){
        if (cur.size() == k){
            ans.add(new ArrayList<>(cur));
            return;
        }

        for(int i = s; i <= n; i++){
            cur.add(i);
            bt(i+1, n, k, ans, cur);
            cur.remove(cur.size()-1);
        }

    }
}