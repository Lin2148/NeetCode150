class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;       
        int n = heights[0].length;    

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        List<List<Integer>> result = new ArrayList<>();

            // 4 border dfs
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0);
            dfs(heights, atlantic, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j);
            dfs(heights, atlantic, m - 1, j);
        }


        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }
        return result;
    }

    private void dfs (int[][] heights, boolean[][] ocean, int r, int c){
        ocean[r][c] = true;

        int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
        for (int[] d : dir) {
            int nR = r + d[0];
            int nC = c + d[1];

            // illegal r,c
            if (nR < 0 || nC < 0 || nR >= heights.length || nC >= heights[0].length){
                continue;
            }

            // already compute
            if (ocean[nR][nC]){
                continue;
            }

            if (heights[nR][nC] < heights[r][c]) {
                continue; 
            }

            // insure if can reach then do dfs
            dfs(heights, ocean, nR, nC);
        }
        return;
    }
}