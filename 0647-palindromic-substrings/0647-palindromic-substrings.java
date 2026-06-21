class Solution {
    public int countSubstrings(String s) {
        int len = s.length();
        int ans = 0;

        // 對每個點 當作中心往外掃palin
        for (int i = 0; i < len; i++){
            ans += palin(s, i, i);
            ans += palin(s, i, i + 1);
        }
        return ans;
    }

    private int palin(String s, int i, int j){
        int count = 0;
        while(i >= 0 && j < s.length() && (s.charAt(i) == s.charAt(j))){
            i--;
            j++;
            count++;
        }
        return count;
    }
}