class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int cnt = 0;
        boolean[][] visit = new boolean[m][n];

        for (int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (board[i][j] == word.charAt(0)){
                    if( bt(board, visit, i, j, word, cnt)){
                        return true;
                    }
                }
            }
        }
        // not found
        return false;
    }
    private boolean bt(char[][] board, boolean[][] visit, int i , int j, String word, int cnt){
        //System.out.println("i ="+i + " j="+j + " cntnum = "+cnt );
        if (cnt == word.length()){
            //System.out.println("found");
            return true;
        }

        if (i<0 || i>board.length-1 || j<0 || j > board[0].length-1){
            //System.out.println("kill OOB");
            return false;
        }


        if (board[i][j] != word.charAt(cnt)){
            //System.out.println("kill wrong word");
            return false;
        }
        if (visit[i][j] == true){
            //System.out.println("kill visit");
            return false;
        }

        visit[i][j] = true;
        boolean traverse =  bt(board, visit, i+1, j, word, cnt+1) || 
                            bt(board, visit, i-1, j, word, cnt+1) || 
                            bt(board, visit, i, j+1, word, cnt+1) || 
                            bt(board, visit, i, j-1, word, cnt+1);
        visit[i][j] = false; 
        
        return traverse;
    }
}