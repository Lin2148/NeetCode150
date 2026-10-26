class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        int[] cnt = new int[m*n];
        cnt[0] = 1;

        for (int i = 1; i < m; i++){
            if (obstacleGrid[i][0]==0 && cnt[(i-1)*n] == 1){
                cnt[n*i] = 1;
            } else{
                cnt[n*i] = 0;
            }
        }

        for (int j = 1; j < n; j++){
            if (obstacleGrid[0][j]==0 && cnt[j-1] == 1){
                cnt[j] = 1;
            } else{
                cnt[j] = 0;
            }
        }
        for (int i = 1; i < m; i++){
            for (int j = 1; j < n; j++){
                int cur = i*n+j;
                if (obstacleGrid[i][j]==1){
                    cnt[cur] = 0;
                } else {
                    cnt[cur] = cnt[(i-1)*n+j] + cnt[i*n+j-1];
                }
            }
        }
        return cnt[m*n-1];
    }
}