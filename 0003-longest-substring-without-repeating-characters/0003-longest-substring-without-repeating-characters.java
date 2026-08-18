 //清掉table比較慢 用hm.get(c)+1 or start記錄下一次起點位置
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int start = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        
        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (hm.containsKey(c)) {   
                start = Math.max(start,hm.get(c)+1);  //abba 本來a開頭 變成b開頭
            } 
            hm.put(c, end);
            maxLength = Math.max(maxLength, end-start+1);
        }
        return maxLength;
    }
}