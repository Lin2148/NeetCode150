class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        if(s2.length() < n) return false;

        int[] cnt = new int[26];
        int[] cmp = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[s1.charAt(i) - 'a']++;
            cmp[s2.charAt(i) - 'a']++;
        }



        int left = 0;
        int right = n;
        
        while (right < s2.length()){
            if(Arrays.equals(cnt, cmp)){
                return true;
            }

            cmp[s2.charAt(right) - 'a']++;
            cmp[s2.charAt(left) - 'a']--;

            left++;
            right++;
        }

        return Arrays.equals(cnt, cmp);
    }
}