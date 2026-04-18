class Solution {
    public int orangesRotting(int[][] grid) {
        // store (x,y) coordinate
        Queue<int[]> queue = new LinkedList<>();

        int fresh = 0, time = 0;
        int row = grid.length;
        int col = grid[0].length;

        // check rotten position and fresh cnt
        for (int r = 0; r < row; r++){
            for (int c = 0; c < col; c++){
                if (grid[r][c] == 2){
                    queue.add(new int[]{r,c});
                }
                if (grid[r][c] == 1){
                    fresh++;
                }
            }
        }

        if (fresh == 0) return 0;
        int[][] dirs = {
            {1, 0}, {-1, 0}, {0, 1}, {0, -1}   
        };

        // BFS 
        while (!queue.isEmpty() && fresh > 0){
            int size = queue.size();
            for (int i = 0; i < size ; i++){
                int[] cur = queue.poll();

                // four dir handle
                for (int[] d : dirs){
                    int nr = cur[0] + d[0];
                    int nc = cur[1] + d[1];

                    // legal (x,y)
                    if (nr >= 0 && nc >= 0 && nr < row && nc < col){
                        if (grid[nr][nc] == 1){
                            grid[nr][nc] = 2;
                            queue.add(new int[]{nr, nc});
                            fresh--;
                        }
                    }
                }
            }   
            time++;
        }
        return (fresh==0) ? time : -1;
    }
}