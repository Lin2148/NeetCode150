class Solution {
    public int characterReplacement(String s, int k) {
        int ans = 0;
        int left = 0;
        //存出現最多次的string
        int max = 0;
        // 存出現次數
        Map<Character, Integer> map = new HashMap<>();

        for (int right = 0; right < s.length(); right++){
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            max = Math.max (max, map.get(c));
            // l~r非法  l右移
            if  ((right - left + 1 - max) > k){
                //縮窗戶  map次數-1
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            ans = Math.max (ans, right-left+1);
        }
        return ans;
    }
}