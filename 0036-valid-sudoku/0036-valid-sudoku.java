class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        // row
        for (int i = 0; i < board.length; i++){
            boolean ans[] = new boolean[10];

            for (int j = 0; j < board.length; j++){
                if (board[i][j] != '.'){
                    int num = board[i][j] - '0';
                    if (ans[num] == true){
                        return false;
                    }
                    else {
                    ans[num] = true;
                    }
                }    
            }
        }
            
        // col
        for (int i = 0; i < board.length; i++){
            boolean ans[] = new boolean[10];

            for (int j = 0; j < board.length; j++){
                if (board[j][i] != '.'){
                    int num = board[j][i] - '0';
                    if (ans[num] == true){
                        return false;
                    }
                    else {
                    ans[num] = true;
                    }
                }    
            }
        }

        // 9
        for (int i = 0; i < board.length; i++){
            boolean ans[] = new boolean[10];

            for (int j = 0; j < board.length; j++){
                int row = (i / 3) * 3 + (j / 3);
                int col = (i % 3) * 3 + (j % 3);
                if (board[row][col] != '.'){
                    int num = board[row][col] - '0';
                    if (ans[num] == true){
                        return false;
                    }
                    else {
                    ans[num] = true;
                    }
                }    
            }
        }
        return true;
    }
}