class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // DP作為前i個char能不能切成合法
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for(int i = 1; i < n + 1; i++){
            // 找0~i之前 是true的
            for (int j = 0; j < i; j++){
                if (dp[j] == true){
                    // 判斷j~i的字串
                    if (wordDict.contains(s.substring(j, i))){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
    return dp[n];
    }
}