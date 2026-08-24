class Solution {
    public List<Integer> partitionLabels(String s) {
        List<Integer> ans = new ArrayList<>();
        //store each char last appear position
        Map<Character,Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length();i++){
            hm.put(s.charAt(i),i);
        }

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++){
            end = Math.max(end,hm.get(s.charAt(i)));
            if (i==end){
                ans.add(i-start+1);
                start=i+1;
            }
        }
        return ans;
    }
}