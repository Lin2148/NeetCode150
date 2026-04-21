class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int topRow = 0, leftCol = 0;
        int downRow = m - 1;
        int rightCol = n - 1;
        List<Integer> ans = new ArrayList<>();

        while (topRow <= downRow && rightCol >= leftCol){
            for (int i = leftCol; i <= rightCol; i++){
                ans.add(matrix[topRow][i]);
            }
            topRow++;

            for (int j = topRow; j <= downRow; j++ ){
                ans.add(matrix[j][rightCol]);
            }
            rightCol--;
            if (topRow <= downRow){
                for (int k = rightCol; k >= leftCol; k-- ){
                    ans.add(matrix[downRow][k]);
                }
                downRow--;
            }
            
            if(rightCol >= leftCol){
                for (int v = downRow; v >= topRow; v-- ){
                    ans.add(matrix[v][leftCol]);
                }
                leftCol++;
            }
            
        }
        return ans;
    }
}