class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length; 
        int left = 0, right = m * n - 1;

        while (left <= right){
            int mid = (left+right) / 2;
            int row = mid / n, col = mid % n;
            int val = matrix[row][col];

            if (val == target){
                return true;
            }
            else if (val > target){
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
        }
    return false;
    }
}