class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>(); 

        for (String s : strs){
            ArrayList<String> list = new ArrayList<>();
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            String sortStr = new String(charArr);

            if (!map.containsKey(sortStr)){
                map.put(sortStr, list);
            }
            
            map.get(sortStr).add(s);
        }
    return new ArrayList<>(map.values());
    }
}