class Solution {
    public void rotate(int[][] matrix) {
        // transpose
        int m = matrix[0].length; 
        for (int i = 0; i < m; i++){
            for (int j = 0; j < m; j++){
                if(i > j){
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }
        }
        //System.out.println(Arrays.deepToString(matrix));
        // reverse row
        for (int i = 0; i < m; i++){
            int front = 0, tail = m - 1;
            while (front < tail){
                int tmp = matrix[i][front];
                matrix[i][front] = matrix[i][tail];
                matrix[i][tail] = tmp;
                front++;
                tail--;
            }
        }
    }
}