class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        if(s2.length() < n) return false;

        int[] cnt = new int[26];
        for (char c : s1.toCharArray()){
            cnt[c-'a'] += 1;
        }



        int left = 0;
        int right = n-1;
        
        while (right < s2.length()){
            int[] cmp = new int[26];
            String subStr = s2.substring(left, right+1);
            for (char c : subStr.toCharArray()){
                cmp[c-'a'] += 1;
            }
            if(Arrays.equals(cnt, cmp)){
                return true;
            }
            left++;
            right++;
        }

        return false;
    }
}