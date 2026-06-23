class Solution {

    private Integer[][] dp; 

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        
        dp = new Integer[m][n]; 
    
        return dfs(text1, text2, 0, 0);
    }


    private int dfs(String text1, String text2, int i, int j) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (text1.charAt(i) == text2.charAt(j)){
            dp[i][j] = 1 + dfs(text1, text2, i + 1, j + 1);
        }
        else {
            dp[i][j] =  Math.max(dfs(text1, text2, i + 1, j), dfs(text1, text2, i, j + 1));
        }
        return dp[i][j];
    }
}