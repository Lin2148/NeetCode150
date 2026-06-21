class Solution {
    public int numDecodings(String s) {
        if (s == null || s.charAt(0) == '0' || s.length() == 0){
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n];

        dp[0] = 1;
        if (n==1){
            return dp[0];
        }

        //dp[1]
        if (s.charAt(1) != '0') {
            dp[1] += dp[0];
        }

        int num = Integer.parseInt(s.substring(0, 2));
        if (num >= 10 && num <= 26) {
            dp[1] += 1;
        }

        //後面的
        for (int i = 2; i < n; i++){
            if (s.charAt(i) != '0'){
                dp[i] += dp[i-1];
            }

            int num2 = Integer.parseInt(s.substring(i - 1, i + 1));
            if (10 <= num2 && num2 <= 26){
                dp[i] += dp[i - 2];
            }
        }
        return dp[n - 1];
    }
}