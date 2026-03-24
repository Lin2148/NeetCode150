class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2; 
        
        int pre = 1;
        int curr = 2;
        for (int i = 3; i <= n; i++){
            int tmp = pre + curr;
            pre = curr;
            curr = tmp;
        }
        return curr;
    } 
}