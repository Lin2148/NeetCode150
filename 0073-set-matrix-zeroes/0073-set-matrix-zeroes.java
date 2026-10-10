class Solution {
    public void setZeroes(int[][] matrix) {
        boolean rowZero = false;
        boolean colZero = false;
        for (int i = 0; i < matrix.length; i++){
            if (matrix[i][0] == 0){
                colZero = true;
                break;
            }
        }

        for (int i = 0; i < matrix[0].length; i++){
            if (matrix[0][i] == 0){
                rowZero = true;
                break;
            }
        }

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++){
            for (int j = 1; j < matrix[0].length; j++){
                if (matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if (rowZero){
            for (int i = 0; i < matrix[0].length; i++){
                    matrix[0][i] = 0;
            }
        }

        if (colZero){
            for (int i = 0; i < matrix.length; i++){
                    matrix[i][0] = 0;
            }
        }
    }
}
/*
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean[] rowCnt = new boolean[matrix.length];
        boolean[] colCnt = new boolean[matrix[0].length];
        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (matrix[i][j] == 0){
                    rowCnt[i] = true;
                    colCnt[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[0].length; j++){
                if (rowCnt[i] == true || colCnt[j] == true){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
*/