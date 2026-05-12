class Solution {
    public void solve(char[][] board) {
        if (board == null) return;
        int row = board.length;
        int col = board[0].length;

        // 首尾列
        for (int c = 0; c < col; c++){
            if(board[0][c] == 'O'){
                dfs(board, 0, c);
            }
            if(board[row-1][c] == 'O'){
                dfs(board, row-1, c);
            }
        }
        // 首尾行
        for (int r = 0; r < row; r++){
            if(board[r][0] == 'O'){
                dfs(board, r, 0);
            }
            if(board[r][col - 1] == 'O'){
                dfs(board, r, col-1);
            }
        }

        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (board[i][j] == 'O') {
                    board[i][j] = 'X'; 
                }
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c) {
    if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O') {
        return;
    }
    board[r][c] = 'T';

    dfs(board, r + 1, c); 
    dfs(board, r - 1, c); 
    dfs(board, r, c + 1); 
    dfs(board, r, c - 1); 
}
}